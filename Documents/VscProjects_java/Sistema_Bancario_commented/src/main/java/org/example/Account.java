// indica que la clase Account pertenece al paquete org.example
package org.example;

// se define una clase pública llamada Account
public class Account {

/*
 * estas lineas declaran dos variables privadas de instancia (accountNumber y balance).
 * La palabra clave private significa que estas variables
 * solo pueden ser accedidas desde dentro de la clase Account
 */
    private String accountNumber;
    private double balance;

    /*
     * Este es el constructor de la clase Account. Se utiliza para inicializar
     * las variables de instancia accountNumber y balance cuando se crea un nuevo objeto de Account.
     */
    // Constructor
    public Account(String accountNumber, double balance) {

        // estas lineas inicializan la variables de instancia con el valor pasado al constructor.
        this.accountNumber = accountNumber; // Asigna el valor del parámetro al campo de instancia
        this.balance = balance;     // Asigna el valor del parámetro al campo de instancia
    }

    // Métodos getter y setter

    /*
     * Los getters (getAccountNumber y getBalance) se utilizan para obtener el valor de las variables privadas,
     * mientras que los setters (setAccountNumber y setBalance) se utilizan para modificar estos valores.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Método para depositar dinero

     /*
     * El método deposit permite agregar dinero a la cuenta. Primero verifica si el amount (cantidad)
     * es mayor que 0, y si lo es, lo suma al balance (saldo).
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Método para retirar dinero

    /*
     * Este método withdraw permite retirar dinero de la cuenta. Verifica que la cantidad a retirar
     * sea mayor que 0 y que haya suficiente saldo (balance >= amount) antes de restar la cantidad del saldo.
     */
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    // Método toString para representar la cuenta

    /*
     * Método toString, se sobrescribe de la clase Object. Devuelve una representación en forma de cadena de la cuenta,
     * incluyendo el número de cuenta y el saldo, formateado con dos decimales.
     */
    @Override
    public String toString() {
        return String.format("Número de cuenta: %s\nSaldo: %.2f", accountNumber, balance);
    }
}