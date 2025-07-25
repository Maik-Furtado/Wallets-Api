package br.com.mkanton.walletsapi.service;

import br.com.mkanton.walletsapi.dto.TransferDto;
import br.com.mkanton.walletsapi.entity.Transfer;
import br.com.mkanton.walletsapi.entity.Wallet;
import br.com.mkanton.walletsapi.exception.*;
import br.com.mkanton.walletsapi.repository.TransferRepository;
import br.com.mkanton.walletsapi.repository.WalletRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling wallet transfers.
 */
@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final WalletRepository walletRepository;

    public TransferService( TransferRepository transferRepository,WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.walletRepository = walletRepository;
    }


    /**
     * Performs a transfer between two wallets after validating the transaction.
     */
    @Transactional
    public Transfer transfer(@Valid TransferDto transferDto) {
      var sender =  walletRepository.findById(transferDto.payer()).orElseThrow(()->new WalletNotFoundException(transferDto.payer()));

      var receiver = walletRepository.findById(transferDto.payee()).orElseThrow(()->new WalletNotFoundException(transferDto.payee()));

      validateTransfer(transferDto,sender);

      sender.debit(transferDto.value());
      receiver.credit(transferDto.value());

      var transfer = new Transfer(sender,receiver,transferDto.value());

      walletRepository.save(sender);
      walletRepository.save(receiver);
      var transferResult = transferRepository.save(transfer);
      
      return transferResult;
    }

    private void validateTransfer(@Valid TransferDto transferDto, Wallet sender) {
        if(!sender.isTransferAllowedForWalletType()){
            throw new TransferNotAllowedWalletTypeException();
        }
        if(!sender.isBalancerEqualOrGreaterThan(transferDto.value())){
            throw new InsufficientBalanceException();
        }

    }
}
