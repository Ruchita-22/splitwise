package com.scaler.splitwise.model;

import com.scaler.splitwise.model.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Expense extends BaseModel{
    private String description;
    private double amount;
    @ManyToOne
    private Group group;
/*    private HashMap<User, Double>  paidByUsers;
      private HashMap<User, Double>  hasToPayUsers;

 */

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserExpense> userExpenses;

    @Enumerated(value = EnumType.ORDINAL)
    private Currency currency;
}
