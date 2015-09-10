package com.pabili.web.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.pabili.commons.dto.BankInfo;
import com.pabili.commons.util.Bank;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/bank")
public class BankResource {

    @RequestMapping(method = GET)
    public ResponseEntity<List<BankInfo>> banks() {
        return new ResponseEntity<>(bankInfoList(), OK);
    }

    private List<BankInfo> bankInfoList() {
        List<BankInfo> bankInfoList = Lists.newArrayList();
        for (Bank bank : Bank.values()) {
            bankInfoList.add(new BankInfo(bank));
        }
        return bankInfoList;
    }
}
