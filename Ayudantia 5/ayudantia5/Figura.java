// Figura.java - Clase Abstracta (Contrato)
// Conceptos: abstract class, métodos abstractos, no instanciable

package ayudantia5;

/**
 * Clase ABSTRACTA: no se puede instanciar directamente (new Figura() -> error).
 * Define un CONTRATO: toda figura DEBE tener área y perímetro.
 * Las subclases están OBLIGADAS a implementar estos métodos.
 */
public abstract class Figura {
    // Métodos ABSTRACTOS: sin cuerpo, obligatorios en subclases
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}