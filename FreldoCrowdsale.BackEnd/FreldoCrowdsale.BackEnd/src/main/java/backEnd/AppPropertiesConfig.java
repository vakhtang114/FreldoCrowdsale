package backEnd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class AppPropertiesConfig {

    @Value("${contract.url}")
    public String contractUrl;

    @Value("${contract}")
    public String contract;

    @Value("${wallet.private.key}")
    public String walletPrivateKey;

    @Value("${wallet.public.key}")
    public String walletPublicKey;

    @Value("${token}")
    public String token;;
}
