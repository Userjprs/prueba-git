package org.example;

/*
 * La clase SavingsAccount hereda de otra clase llamada Account (Cuenta)
 * La clase SavingsAccount extiende la clase Account.
 * Tiene un atributo privado llamado interestRate que representa la tasa de interés.
 */  

 public class SavingsAccount extends Account {
    private double interestRate;

    /*
     * El constructor de la clase SavingsAccount toma tres parámetros:
     *  accountNumber (número de cuenta), balance (saldo) y interestRate (tasa de interés).
     * Usa super(accountNumber, balance) para llamar al constructor de la superclase Account
     *  y establecer los valores de accountNumber y balance.
     * Asigna el valor del parámetro interestRate al atributo interestRate.
     */
    
    // Constructor
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance); // Llama al constructor de la superclase
        this.interestRate = interestRate;
    }

    /*
     * getInterestRate() devuelve la tasa de interés.
     * setInterestRate(double interestRate) establece la tasa de interés.
     */
    
    // Métodos getter y setter
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /*
     * applyInterest() calcula el interés basado en el saldo actual (getBalance(),
     *  que probablemente es un método de la clase Account) y la tasa de interés.
     * Luego, deposita el interés calculado en la cuenta usando el método deposit()
     *  (que también debe estar definido en la clase Account).
     */

    // Método para aplicar interés
    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    /*
     * toString() devuelve una representación en forma de cadena de la cuenta de ahorros.
     * Usa super.toString() para obtener la representación de la cuenta desde la clase Account
     *  y añade la tasa de interés.
     */

    @Override
    public String toString() {
        return String.format("Cuenta de Ahorros:\n%s\nTasa de interés: %.2f%%", super.toString(), interestRate);
    }
}