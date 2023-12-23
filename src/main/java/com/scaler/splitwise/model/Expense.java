package com.scaler.splitwise.model;

import com.scaler.splitwise.model.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@Entity
public class Expense extends BaseModel{
    private String description;
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;
/*    private HashMap<User, Double>  paidByUsers;
      private HashMap<User, Double>  hasToPayUsers;

 */

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<UserExpense> userExpenses;

    @Enumerated(value = EnumType.ORDINAL)
    private Currency currency;
}
