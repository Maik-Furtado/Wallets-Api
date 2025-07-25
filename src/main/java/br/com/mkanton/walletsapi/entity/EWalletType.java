package br.com.mkanton.walletsapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing different types of wallets.
 */
@Getter
@AllArgsConstructor
public enum EWalletType {

    USER(1L,"user"),
    MERCHANT(2L,"merchant");

    private final Long id;

    private final  String description;

}
