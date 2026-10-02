// SubClaseA.java - Implementa método abstracto de Base

package ayudantia5;

/**
 * SubClaseA: implementación propia de metodo2().
 * Hereda metodo1() de Base tal cual.
 */
public class SubClaseA extends Base {
    @Override
    public void metodo2() {
        contador += 3;
        System.out.println("SubClaseA.metodo2() -> contador = " + contador);
    }
}