package com.scaler.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNUMBER;
    @ManyToMany
    private List<Expense> expenses;
    @ManyToMany
    private List<Group> groups;
}
