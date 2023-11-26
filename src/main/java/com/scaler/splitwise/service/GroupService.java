package com.scaler.splitwise.service;

import com.scaler.splitwise.dto.TransactionDTO;

import java.util.List;

public interface GroupService {
    List<TransactionDTO> settleUp();
}
