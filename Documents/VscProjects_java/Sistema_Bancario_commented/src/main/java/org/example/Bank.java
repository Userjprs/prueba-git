package org.example;    // define el paquete al que pertenece esta clase.

/*
 *  importaciones necesarias para utilizar la clase ArrayList y la interfaz List.
 */
import java.util.ArrayList;
import java.util.List;

/*
 * La clase Bank tiene una lista de cuentas (accounts) que es una ArrayList de objetos Account.
 * El constructor inicializa la lista de cuentas.
 * El método addAccount agrega una nueva cuenta a la lista.
 * El método findAccount busca una cuenta por su número de cuenta. Si encuentra una coincidencia,
 *  devuelve la cuenta; de lo contrario, devuelve null.
 * El método displayAllAccounts muestra todas las cuentas en la consola.
 */
public class Bank {
    private List<Account> accounts;

    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
    }

    // Método para agregar una cuenta
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Método para buscar una cuenta por número de cuenta
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Método para mostrar todas las cuentas
    public void displayAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account + "\n");
        }
    }

    /*
     * El método main es el punto de entrada del programa.
     * Se crea una instancia de Bank.
     * Se crean dos cuentas: una cuenta de ahorros (SavingsAccount)
     *  y una cuenta corriente (CheckingAccount) con números de cuenta,
     *  saldo inicial y otros parámetros específicos.
     * Las cuentas se agregan al banco usando addAccount.
     * Se muestran todas las cuentas iniciales en la consola.
     * Se aplica el interés a la cuenta de ahorros usando el método applyInterest.
     * Se realiza un retiro de la cuenta corriente, permitiendo sobregiro.
     * Se muestran las cuentas actualizadas después de cada operación.
     */
    
    // Método main: punto de entrada del programa
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Crear cuentas
        SavingsAccount savings = new SavingsAccount("SA123", 1000.0, 5.0);
        CheckingAccount checking = new CheckingAccount("CA123", 500.0, 200.0);

        // Agregar cuentas al banco
        bank.addAccount(savings);
        bank.addAccount(checking);

        // Mostrar todas las cuentas
        System.out.println("Cuentas iniciales:");
        bank.displayAllAccounts();

        // Aplicar interés a la cuenta de ahorros
        savings.applyInterest();
        System.out.println("Después de aplicar interés a la cuenta de ahorros:");
        System.out.println(savings + "\n");

        // Retirar dinero de la cuenta corriente con sobregiro
        checking.withdraw(600);
        System.out.println("Después de retirar dinero con sobregiro:");
        System.out.println(checking + "\n");
    }
}