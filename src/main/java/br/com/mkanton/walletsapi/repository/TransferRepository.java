package br.com.mkanton.walletsapi.repository;

import br.com.mkanton.walletsapi.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Long> {
}
