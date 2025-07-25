package br.com.mkanton.walletsapi.dto;

import br.com.mkanton.walletsapi.entity.EWalletType;
import br.com.mkanton.walletsapi.validator.ValidCpfCnpj;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Data for creating a new wallet.")
public record CreateWalletDto(
        String fullName,

        @ValidCpfCnpj
        @Schema(description = "Valid CPF or CNPJ", example = "123.456.789-00")
        String cpfCnpj,

        @Schema(description = "User's email", example = "joao@email.com")
        String email,

        @Schema(description = "Wallet password", example = "passwordSegura123")
        String password,

        @Schema(description = "Wallet Starting Balance", example = "500.00")
        BigDecimal balance,

        @Schema(description = "Wallet type (USER or MERCHANT)", example = "USER")
        EWalletType walletType) {

}
