// Triangulo.java - Implementación concreta de Figura

package ayudantia5;

/**
 * Triángulo rectángulo: implementa el contrato de Figura.
 */
public class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        // Triángulo rectángulo: hipotenusa = sqrt(base² + altura²)
        double hipotenusa = Math.sqrt(base * base + altura * altura);
        return base + altura + hipotenusa;
    }
}