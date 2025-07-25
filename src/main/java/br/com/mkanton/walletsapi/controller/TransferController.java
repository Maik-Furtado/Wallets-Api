package br.com.mkanton.walletsapi.controller;

import br.com.mkanton.walletsapi.dto.TransferDto;
import br.com.mkanton.walletsapi.entity.Transfer;
import br.com.mkanton.walletsapi.service.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Transfers", description = "Operations related to transfers between wallets")
@RestController
    public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @Operation(
            summary = "Perform transfer",
            description = "Transfer an amount between two existing wallets.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Transfer successful"),
                    @ApiResponse(responseCode = "400", description = "Validation error or operation not allowed")}
    )
    @PostMapping("/transfers")
    public ResponseEntity<Transfer> transfer (@RequestBody @Valid TransferDto dto){

        var resp = transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }
}
