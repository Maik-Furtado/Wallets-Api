package br.com.mkanton.walletsapi.service;

import br.com.mkanton.walletsapi.dto.CreateWalletDto;
import br.com.mkanton.walletsapi.entity.Wallet;
import br.com.mkanton.walletsapi.entity.WalletType;
import br.com.mkanton.walletsapi.exception.WalletDataAlreadyExistsException;
import br.com.mkanton.walletsapi.repository.WalletRepository;
import br.com.mkanton.walletsapi.repository.WalletTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Service class responsible for wallet operations.
 */
@Service
public class WalletService {

    private final WalletRepository walletRepository;

    private final WalletTypeRepository walletTypeRepository;

    public WalletService(WalletRepository walletRepository, WalletTypeRepository walletTypeRepository) {
        this.walletRepository = walletRepository;
        this.walletTypeRepository = walletTypeRepository;
    }



    /**
     * Creates a new wallet ensuring CPF/CNPJ and email uniqueness.
     */
    public Wallet createWallet(CreateWalletDto dto) {

        walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(),dto.email()).ifPresent(w -> {
            throw new WalletDataAlreadyExistsException("CPF,CNPJ or email already exists");});

        WalletType type = walletTypeRepository.findById(dto.walletType().getId()).orElseThrow(()->new EntityNotFoundException("Type not found"));

        Wallet wallet = new Wallet(dto.fullName(),dto.cpfCnpj(),dto.email(),dto.password(),dto.balance(),type);

        return walletRepository.save(wallet);
    }
}
