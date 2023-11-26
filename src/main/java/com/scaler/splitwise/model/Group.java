package com.scaler.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Group extends BaseModel {
    private String name;

    private String description;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Expense> expenses;

    private double totalAmountSpend;
}
