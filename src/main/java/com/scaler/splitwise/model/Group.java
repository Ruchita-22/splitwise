package com.scaler.splitwise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity(name = "splitwise_group")
public class Group extends BaseModel {
    private String name;

    private String description;

    @ManyToMany(mappedBy = "groups",cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private List<Expense> expenses;

    private double totalAmountSpend;
}
