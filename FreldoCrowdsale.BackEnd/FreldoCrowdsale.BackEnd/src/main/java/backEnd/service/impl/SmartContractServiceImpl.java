package backEnd.service.impl;

import backEnd.contract.FreldoCrowdsaleService;
import backEnd.service.SmartContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SmartContractServiceImpl implements SmartContractService {

    @Autowired
    private FreldoCrowdsaleService contractService;

    @Override
    public Float getBalance() {
        return contractService.currentBalance();
    }

    @Override
    public BigInteger getCap() {
        return contractService.cap();
    }

    @Override
    public BigInteger getGoal() {
        return contractService.goal();
    }

    @Override
    public String getTokenAddress() {
        return contractService.token();
    }

    @Override
    public String getContractAddress() {
        return contractService.getContractAddress();
    }
}
