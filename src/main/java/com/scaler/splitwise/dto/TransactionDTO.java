package com.scaler.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TransactionDTO {
    private String fromUserName;
    private String toUserName;
    private double amount;
}
