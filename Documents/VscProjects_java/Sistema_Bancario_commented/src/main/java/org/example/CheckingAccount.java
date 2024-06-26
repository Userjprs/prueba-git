//  Define el paquete al que pertenece la clase.
//Los paquetes se utilizan para organizar las clases en Java.
package org.example;

/*
 * Declara una clase pública llamada CheckingAccount que hereda de otra clase llamada Account.
 * Declara un atributo privado llamado overdraftLimit, que representa el límite de sobregiro
 *  permitido en la cuenta.
 */
public class CheckingAccount extends Account {
    private double overdraftLimit;

    /*
     * El constructor de la clase CheckingAccount toma tres parámetros: accountNumber,
     *  balance y overdraftLimit.
     * super(accountNumber, balance);: Llama al constructor de la superclase Account
     *  para inicializar los atributos accountNumber y balance.
     * this.overdraftLimit = overdraftLimit;: Inicializa el atributo overdraftLimit
     *  con el valor pasado como parámetro.
     */
    
    // Constructor
    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance); // Llama al constructor de la superclase
        this.overdraftLimit = overdraftLimit;
    }

    /*
     * getOverdraftLimit(): Método público que devuelve el valor del atributo overdraftLimit.
     * setOverdraftLimit(double overdraftLimit): Método público que establece el valor
     *  del atributo overdraftLimit.
     */
    
    // Métodos getter y setter
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /*
     * @Override: Indica que este método sobrescribe el método withdraw de la superclase Account.
     * withdraw(double amount): Método que permite retirar una cantidad de dinero de la cuenta,
     *  considerando el límite de sobregiro.
     * if (amount > 0 && getBalance() + overdraftLimit >= amount): Comprueba que la cantidad a retirar
     *  sea positiva y que el balance de la cuenta más el límite de sobregiro sea suficiente para cubrir
     *  la cantidad a retirar.
     * setBalance(getBalance() - amount);: Si las condiciones son verdaderas, reduce el balance de la cuenta
     *  por la cantidad especificada.
     */
    
    // Método para retirar dinero con overdraft
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() + overdraftLimit >= amount) {
            setBalance(getBalance() - amount);
        }
    }

    /*
     * @Override: Indica que este método sobrescribe el método toString de la superclase Account.
     * toString(): Método que devuelve una representación en forma de cadena de la cuenta corriente.
     * String.format("Cuenta Corriente:\n%s\nLímite de sobregiro: %.2f", super.toString(),overdraftLimit);:
     *  Formatea una cadena que incluye la representación de la cuenta (utilizando el método toString de la superclase)
     *  y el límite de sobregiro.
     */

    @Override
    public String toString() {
        return String.format("Cuenta Corriente:\n%s\nLímite de sobregiro: %.2f", super.toString(), overdraftLimit);
    }
}