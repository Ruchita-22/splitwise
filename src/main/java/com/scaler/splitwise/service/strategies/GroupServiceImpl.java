package com.scaler.splitwise.service.strategies;

import com.scaler.splitwise.dto.TransactionDTO;
import com.scaler.splitwise.repository.UserRepository;
import com.scaler.splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    UserRepository userRepository; // ideal way should be to call a method in userService that calls the userRepository to get the users

    @Override
    public List<TransactionDTO> settleUp() {
        return null;
    }
}
