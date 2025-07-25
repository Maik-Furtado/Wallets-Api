package br.com.mkanton.walletsapi.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTypeTest {

    @Test
    @DisplayName("from() must create a WalletType with id and description of the enum")
    void testFromFactory(){
        WalletType wtUser = WalletType.from(EWalletType.USER);
        assertEquals(1L, wtUser.getId());
        assertEquals("user", wtUser.getDescription());

        WalletType wtMerchant = WalletType.from(EWalletType.MERCHANT);
        assertEquals(2L, wtMerchant.getId());
        assertEquals("merchant", wtMerchant.getDescription());
    }

}
