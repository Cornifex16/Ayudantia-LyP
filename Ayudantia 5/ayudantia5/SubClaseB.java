// SubClaseB.java - Otra implementación de Base

package ayudantia5;

/**
 * SubClaseB: distinta implementación de metodo2().
 * También hereda metodo1() de Base.
 */
public class SubClaseB extends Base {
    @Override
    public void metodo2() {
        contador += 2;
        System.out.println("SubClaseB.metodo2() -> contador = " + contador);
    }
}