// CuentaBancaria.java - Encapsulamiento con lógica de negocio
// Conceptos: private, validaciones en métodos, estado interno protegido

package ayudantia5;

/**
 * Cuenta bancaria que demuestra ENCAPSULAMIENTO completo.
 * - Atributos privados: titular, saldo, transacciones
 * - Métodos públicos con validaciones de negocio
 * - Estado interno nunca expuesto directamente
 */
public class CuentaBancaria {
    private String titular;
    private double saldo;
    private int numeroTransacciones;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = Math.max(0, saldoInicial);
        this.numeroTransacciones = 0;
    }

    // Getters (solo lectura)
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public int getNumeroTransacciones() { return numeroTransacciones; }

    // Métodos de NEGOCIO con validaciones (encapsulan la lógica)
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            numeroTransacciones++;
            System.out.println("  [OK] Depósito de $" + monto);
        } else {
            System.out.println("  [Error] Monto debe ser positivo");
        }
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("  [Error] Monto debe ser positivo");
            return false;
        }
        if (monto > saldo) {
            System.out.println("  [Error] Fondos insuficientes (saldo: $" + saldo + ")");
            return false;
        }
        saldo -= monto;
        numeroTransacciones++;
        System.out.println("  [OK] Retiro de $" + monto);
        return true;
    }
}