package backEnd.controller;

import backEnd.service.SmartContractService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigInteger;

@RestController
@RequestMapping(value = "/smart_contract")
@Api(description = "Services for smart contracts", name = "Smart contract controller")
public class SmartContractController {

    @Autowired
    private SmartContractService smartContractService;

    @RequestMapping(value = "/balance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get ether balance in ETH.")
    public @ResponseBody Float getBalance() {
        return smartContractService.getBalance();
    }

    @RequestMapping(value = "/cap", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get hard cap ICO in ETH")
    public @ResponseBody BigInteger getCap() throws IOException {
        return smartContractService.getCap();
    }

    @RequestMapping(value = "/goal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get soft cap ICO in ETH")
    public @ResponseBody BigInteger getGoal() throws IOException {
        return smartContractService.getGoal();
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get token address")
    public @ResponseBody String getTokenAddress() throws IOException {
        return smartContractService.getTokenAddress();
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Method user to get contract address")
    public @ResponseBody String getContractAddress() throws IOException {
        return smartContractService.getContractAddress();
    }
}
