package backEnd.service;

import java.math.BigInteger;

public interface SmartContractService {
    Float getBalance();

    BigInteger getCap();

    BigInteger getGoal();

    String getTokenAddress();

    String getContractAddress();
}
