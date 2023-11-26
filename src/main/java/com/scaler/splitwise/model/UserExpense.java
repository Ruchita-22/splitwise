package com.scaler.splitwise.model;

import com.scaler.splitwise.model.enums.UserExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;

    //1 user expense paid by or had to pay , like A has to pay to B, C, D , so A involve in many expense
    @ManyToOne
    private Expense expense;

    private double amount;

    @Enumerated(value = EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}
