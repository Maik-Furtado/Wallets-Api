package br.com.mkanton.walletsapi.repository;

import br.com.mkanton.walletsapi.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
