package br.com.mkanton.walletsapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(description = "Data to perform a transfer between wallets.")
public record TransferDto(
        @NotNull
        @DecimalMin("0.01")
        @Schema(description = "Transfer Amount", example = "150.00", minimum = "0.01")
        BigDecimal value,

        @NotNull
        @Schema(description = "ID da carteira que vai transferir", example = "1")
        Long payer,

        @NotNull
        @Schema(description = "ID of the wallet you will receive", example = "2")
        Long payee) {
}
