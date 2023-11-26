package com.scaler.splitwise.service;

import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.Group;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.model.UserExpense;
import com.scaler.splitwise.model.enums.Currency;
import com.scaler.splitwise.model.enums.UserExpenseType;
import com.scaler.splitwise.repository.ExpenseRepository;
import com.scaler.splitwise.repository.GroupRepository;
import com.scaler.splitwise.repository.UserExpenseRepository;
import com.scaler.splitwise.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{
    UserRepository userRepository;
    GroupRepository groupRepository;
    ExpenseRepository expenseRepository;
    UserExpenseRepository userExpenseRepository;

    public InitServiceImpl(UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository, UserExpenseRepository userExpenseRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.userExpenseRepository = userExpenseRepository;
    }

    @Override
    public void initialise() {
        // create 4 user
        User user1 = new User();
        user1.setName("A");
        user1.setEmail("a@gmail.com");
        user1.setPhoneNUMBER("9818797930");

        User user2 = new User();
        user2.setName("B");
        user2.setEmail("b@gmail.com");
        user2.setPhoneNUMBER("9818797930");

        User user3 = new User();
        user3.setName("C");
        user3.setEmail("c@gmail.com");
        user3.setPhoneNUMBER("9818797930");

        User user4 = new User();
        user4.setName("D");
        user4.setEmail("d@gmail.com");
        user4.setPhoneNUMBER("9818797930");

        //save all user
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        user3 = userRepository.save(user3);
        user4 = userRepository.save(user4);

        //create group and save
        Group group = new Group();
        group.setDescription("Friends who never pay back on time");
        group.setName("Trip to Manali");
        group.setUsers(List.of(user1, user2, user3, user4));

        group =  groupRepository.save(group);

        UserExpense userExpense = new UserExpense();
        userExpense.setUser(user1);
        userExpense.setAmount(1000);
        userExpense.setUserExpenseType(UserExpenseType.PAID_BY);

        userExpense = userExpenseRepository.save(userExpense);

        UserExpense userExpense1 = new UserExpense();
        userExpense1.setUser(user1);
        userExpense1.setAmount(250);
        userExpense1.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense1 = userExpenseRepository.save(userExpense1);

        UserExpense userExpense2 = new UserExpense();
        userExpense2.setUser(user2);
        userExpense2.setAmount(250);
        userExpense2.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense2 = userExpenseRepository.save(userExpense2);

        UserExpense userExpense3 = new UserExpense();
        userExpense3.setUser(user3);
        userExpense3.setAmount(250);
        userExpense3.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense3 = userExpenseRepository.save(userExpense3);

        UserExpense userExpense4 = new UserExpense();
        userExpense4.setUser(user4);
        userExpense4.setAmount(250);
        userExpense4.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense4 = userExpenseRepository.save(userExpense4);

        Expense expense = new Expense();
        expense.setAmount(1000);
        expense.setDescription("Dinner");
        expense.setCurrency(Currency.INR);
        expense.setUserExpenses(List.of(userExpense, userExpense1, userExpense2, userExpense3, userExpense4));

        expenseRepository.save(expense);


    }
}
