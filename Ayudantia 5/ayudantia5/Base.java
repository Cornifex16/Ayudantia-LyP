// Base.java - Clase Abstracta con métodos concretos Y abstractos
// Conceptos: abstract class, método concreto (heredado), método abstracto (obligatorio)

package ayudantia5;

/**
 * Base: demuestra que una clase abstracta puede tener:
 * - Métodos CONCRETOS: se heredan tal cual (reutilización)
 * - Métodos ABSTRACTOS: obligan a implementar en subclases (contrato)
 */
public abstract class Base {
    protected int contador = 0;

    // Método CONCRETO: implementado aquí, heredado por todas las subclases
    public void metodo1() {
        contador++;
        System.out.println("Base.metodo1() -> contador = " + contador);
    }

    // Método ABSTRACTO: sin implementación, OBLIGATORIO en subclases
    public abstract void metodo2();
}