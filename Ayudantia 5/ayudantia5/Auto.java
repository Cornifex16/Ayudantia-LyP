// Auto.java - Superclase (Generalización)
// Conceptos: clase base, atributos protected, métodos heredables

package ayudantia5;

/**
 * Clase base Auto - representa un vehículo genérico.
 * Usa atributos PROTECTED para que las subclases puedan acceder directamente.
 */
public class Auto {
    // protected: accesible en esta clase, mismo paquete, y SUBCLASES
    protected String marca;
    protected String modelo;
    protected int año;
    protected String color;
    protected int kilometraje;
    
    // private: solo en esta clase
    private String duenho;

    public Auto(String marca, String modelo, int año, String color, int km) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.kilometraje = km;
    }

    // Método que puede ser sobrescrito (@Override en subclase)
    public void conducir(int kms) {
        System.out.println("Conduciendo " + kms + " km");
        kilometraje += kms;
    }

    public void vender(String nuevoDuenho) {
        this.duenho = nuevoDuenho;
        System.out.println("Auto vendido a " + nuevoDuenho);
    }

    public int leerOdometro() { return kilometraje; }

    // Método heredado tal cual (no sobrescrito en FurgonEscolar)
    public void mostrarInfo() {
        System.out.println("  " + marca + " " + modelo + " (" + año + ") " + color);
    }
}