package br.com.mkanton.walletsapi.repository;

import br.com.mkanton.walletsapi.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
