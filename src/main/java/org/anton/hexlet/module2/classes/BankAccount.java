package org.anton.hexlet.module2.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BankAccount {
    //**************************************************************************************************************|
    //                                                   Triangle                                                   |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    private long accountNumber;
    private String accountCurrency;
    private double balance;

    public void deposit(String currency, double amount) {
        if (currency.equals(accountCurrency)) balance += amount;
        else {
            if (accountCurrency.equals("usd")) balance += amount * 1.2;
            else balance += amount / 1.2;
        }
    }

    public void withdraw(String currency, double amount) {
        if (currency.equals(accountCurrency)) {
            if (balance >= amount) balance -= amount;
            else throw new IllegalArgumentException("Insufficient funds");
        } else {
            double convertedAmount;
            if (accountCurrency.equals("usd")) convertedAmount = amount * 1.2;
            else convertedAmount = amount / 1.2;
            if (balance >= convertedAmount) balance -= convertedAmount;
            else throw new IllegalArgumentException("Insufficient funds");
        }
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |

    /*
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    @AllArgsConstructor
    @Getter
    public final class BankAccount {
        private static double exchangeRate = 1.2;
        private long accountNumber;
        private String accountCurrency;
        private double balance;
        public void deposit(String currency, double amount) {
            var normalizedAmount = exchange(currency, amount);
            balance += normalizedAmount;
        }
        public void withdraw(String currency, double amount) {
            var normalizedAmount = exchange(currency, amount);

            if (balance - normalizedAmount >= 0) {
                balance -= normalizedAmount;
            } else {
                throw new IllegalArgumentException("Insufficient funds");
            }
        }
        private double exchange(String currency, double amount) {
            double normalizedAmount;
            if (currency.equals(accountCurrency)) {
                normalizedAmount = amount;
            } else if (accountCurrency.equals("eur")) {
                normalizedAmount = amount / exchangeRate;
            } else {
                normalizedAmount = amount * exchangeRate;
            }
            return normalizedAmount;
        }
    }

     */
}

