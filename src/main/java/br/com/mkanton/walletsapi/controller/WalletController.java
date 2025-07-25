package br.com.mkanton.walletsapi.controller;

import br.com.mkanton.walletsapi.dto.CreateWalletDto;
import br.com.mkanton.walletsapi.entity.Wallet;
import br.com.mkanton.walletsapi.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Wallets", description = "Operations related to creating wallets")
@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @Operation(
            summary = "Create wallet",
            description = "Creates a new wallet with name, CPF/CNPJ, email, balance, and type.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Wallet created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid data provided")}
    )
    @PostMapping("/wallets")
    public ResponseEntity<Wallet>createWallet(@Valid @RequestBody CreateWalletDto dto){

       var wallet = walletService.createWallet(dto);
       return ResponseEntity.ok(wallet);

    }
}
