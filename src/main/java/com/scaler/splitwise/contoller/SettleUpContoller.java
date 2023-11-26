package com.scaler.splitwise.contoller;

import com.scaler.splitwise.dto.SettleUpResponseDTO;
import com.scaler.splitwise.dto.TransactionDTO;
import com.scaler.splitwise.service.GroupService;
import com.scaler.splitwise.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpContoller {
    @Autowired
    InitService initService;
    @Autowired
    private GroupService groupService;

    @GetMapping("/init")
    public ResponseEntity initialise(){
/*        TransactionDTO transactionDTO1 = new TransactionDTO("A", "B", 500);
        TransactionDTO transactionDTO2 = new TransactionDTO("C", "D", 1000);
        List<TransactionDTO> transactions = List.of(transactionDTO1,transactionDTO2);
        SettleUpResponseDTO settleUpResponseDTO = new SettleUpResponseDTO(transactions);
 */
        initService.initialise();
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/settleUp")
    public ResponseEntity settleUp(){
        List<TransactionDTO> transactionDTOS = groupService.settleUp();
        return ResponseEntity.ok(transactionDTOS);
    }
}
