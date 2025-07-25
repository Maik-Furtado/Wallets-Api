package br.com.mkanton.walletsapi.entity;

import jakarta.persistence.*;;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity representing a wallet.
 */
@Entity
@Table(name = "tb_wallet")
@Getter
@Setter
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "cpf_cnpj",unique = true)
    private String cpfCnpj;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;

    public Wallet(String fullName, String cpfCnpj, String email, String password,BigDecimal balance, WalletType walletType) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.walletType = walletType;
    }

    public boolean isTransferAllowedForWalletType() {
        return this.walletType.equals(WalletType.from(EWalletType.USER));
    }

    public boolean isBalancerEqualOrGreaterThan( BigDecimal value) {
        return this.balance.doubleValue() >= value.doubleValue();
    }

    public void debit( BigDecimal value) {
      this.balance =  this.balance.subtract(value);
    }
    public void credit( BigDecimal value) {
        this.balance=this.balance.add(value);
    }


}
