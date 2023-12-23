package com.scaler.splitwise.model;

import com.scaler.splitwise.model.enums.UserExpenseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    //1 user expense paid by or had to pay , like A has to pay to B, C, D , so A involve in many expense
    @ManyToOne(cascade = CascadeType.ALL)
    private Expense expense;

    private double amount;

    @Enumerated(value = EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}
