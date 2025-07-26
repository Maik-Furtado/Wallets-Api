package br.com.mkanton.walletsapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * Entity representing the type of a wallet.
 */
@Entity
@Table(name = "tb_wallet_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WalletType {

    @Id
    @Column(name = "wallet_type_id")
    private Long id;

    @Column(name = "description")
    private String description;

    public static WalletType from(EWalletType type){
        return new WalletType(type.getId(), type.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WalletType type = (WalletType) o;
        return Objects.equals(id, type.id) && Objects.equals(description, type.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
