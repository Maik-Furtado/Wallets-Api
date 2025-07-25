package br.com.mkanton.walletsapi.config;

import br.com.mkanton.walletsapi.entity.EWalletType;
import br.com.mkanton.walletsapi.entity.WalletType;
import br.com.mkanton.walletsapi.repository.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Loads wallet types at application startup.
 */
@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
     Arrays.stream(EWalletType.values()).forEach(wt -> walletTypeRepository.save(WalletType.from(wt)));
    }
}
