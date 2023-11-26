package com.scaler.splitwise.service.strategies;

import com.scaler.splitwise.dto.TransactionDTO;
import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.model.UserExpense;
import com.scaler.splitwise.model.enums.UserExpenseType;

import java.util.*;

public class HeapBasedSettleUpStrategies implements SettleUpStrategy{
    public List<TransactionDTO> settleUp(List<Expense> expenses){

        HashMap<User, Double> userOutstandingBalance = new HashMap<>();

        for(Expense expense : expenses){
            for (UserExpense userExpense : expense.getUserExpenses()){
                //get user
                User user = userExpense.getUser();

                userOutstandingBalance.putIfAbsent(user,0.0);
                // find its currentOutStandingAmount
                double currentOutStandingAmount = userOutstandingBalance.get(user);

                if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID_BY)){
                    currentOutStandingAmount = currentOutStandingAmount + userExpense.getAmount();
                } else {
                    currentOutStandingAmount = currentOutStandingAmount - userExpense.getAmount();
                }
                //update its currentOutStandingAmount
                userOutstandingBalance.put(user,currentOutStandingAmount);

            }
        }
        //maxHeap for all PAID users [ +ve balance ]
        PriorityQueue<Map.Entry<User, Double>> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getValue(), a.getValue())
        );
        //minHeap for all HasToPay users [ -ve balance ]
        PriorityQueue<Map.Entry<User, Double>> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(Map.Entry::getValue)
        );

        // put value in minHeap or maxHeap
        for (Map.Entry<User,Double> entry : userOutstandingBalance.entrySet()){
            if (entry.getValue() < 0)   minHeap.add(entry);
            else if (entry.getValue() > 0) maxHeap.add(entry);
            else
                System.out.println(entry.getKey().getName() + " is already settled, no need to be part of transactions");
        }

        List<TransactionDTO> transactionList = new ArrayList<>();

        while (minHeap.size()>0){
            Map.Entry<User, Double> maxHasToPay = minHeap.poll();
            Map.Entry<User, Double> maxPaid = maxHeap.poll();
            TransactionDTO transaction = new TransactionDTO(
                    maxHasToPay.getKey().getName(),
                    maxPaid.getKey().getName(),
                    Math.min(Math.abs(maxHasToPay.getValue()), Math.abs(maxPaid.getValue())));

            transactionList.add(transaction);

            double outstanding = maxPaid.getValue()+maxHasToPay.getValue();
            if (outstanding < 0){
                maxHasToPay.setValue(outstanding);
                minHeap.add(maxHasToPay);
            }
            else if(outstanding > 0){
                maxPaid.setValue(outstanding);
                maxHeap.add(maxPaid);
            }
            else{
                System.out.println("Settled");
            }

        }
        return transactionList;

    }
}
