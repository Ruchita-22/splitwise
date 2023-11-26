package com.scaler.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class SettleUpResponseDTO {
    private List<TransactionDTO> transactionDTOS;
}
