package com.scaler.splitwise.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNUMBER;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Expense> expenses;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Group> groups;
}
