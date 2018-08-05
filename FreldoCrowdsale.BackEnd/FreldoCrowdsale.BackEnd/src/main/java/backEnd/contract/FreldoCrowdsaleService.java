package backEnd.contract;

import backEnd.AppPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.math.BigInteger;

@Component
public class FreldoCrowdsaleService {

    private static FreldoCrowdsale CONTRACT;

    private static Long WEI_RATE = 1000000000000000000L;

    @Autowired
    private AppPropertiesConfig config;

    @Autowired
    private void init() throws Exception {
        Web3j WEB3J = Web3j.build(new HttpService(config.contractUrl));

        String hexPrivateKey = String.format("%040x", new BigInteger(1, config.walletPrivateKey.getBytes()));
        String hexPublicKey = String.format("%040x", new BigInteger(1, config.walletPublicKey.getBytes()));
        Credentials CREDENTIALS = Credentials.create(hexPrivateKey, hexPublicKey);

        CONTRACT = FreldoCrowdsale.load(config.contract, WEB3J, CREDENTIALS, Contract.GAS_PRICE, Contract.GAS_LIMIT);
    }

    public Float currentBalance(){
        RemoteCall<BigInteger> weiRaised = CONTRACT.weiRaised();
        Float balance = null;
        try {
            BigInteger contractBalance = weiRaised.send();
            balance = (contractBalance.floatValue() / Float.valueOf(WEI_RATE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    public BigInteger cap() {
        RemoteCall<BigInteger> capAmount = CONTRACT.cap();
        BigInteger cap = null;
        try {
            cap = capAmount.send().divide(BigInteger.valueOf(WEI_RATE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cap;
    }

    public BigInteger goal() {
        RemoteCall<BigInteger> goalAmount = CONTRACT.goal();
        BigInteger goal = null;
        try {
            goal = goalAmount.send().divide(BigInteger.valueOf(WEI_RATE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goal;
    }

    public String token() {
        RemoteCall<String> token = CONTRACT.token();
        String tokenAddress = null;
        try {
            tokenAddress = token.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenAddress;
    }

    public String getContractAddress() {
        return CONTRACT.getContractAddress();
    }
}
