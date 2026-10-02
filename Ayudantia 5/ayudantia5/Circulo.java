// Circulo.java - Implementación concreta de Figura

package ayudantia5;

/**
 * Círculo: implementa el contrato de Figura.
 * Debe proporcionar calcularArea() y calcularPerimetro().
 */
public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}