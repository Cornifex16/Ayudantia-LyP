// Enemigo.java - Subclase concreta de Personaje

package ayudantia5;

/**
 * Enemigo: implementa los pasos del template method de forma distinta.
 * - Movimiento: aleatorio (-1, 0, 1 en cada eje)
 * - Energía: constante (-1 por turno)
 * - Saludo: amenaza + posición
 */
public class Enemigo extends Personaje {
    public Enemigo(String nombre, int x, int y, int energia) {
        super(nombre, x, y, energia);
    }

    @Override
    protected void moverse() {
        // Movimiento aleatorio en 2D
        x += (int)(Math.random() * 3) - 1;  // -1, 0, o 1
        y += (int)(Math.random() * 3) - 1;
    }

    @Override
    protected void gastarEnergia() {
        setEnergia(getEnergia() - 1);  // Tasa constante
    }

    @Override
    protected void saludar() {
        System.out.println("¡Te atraparé!");
        System.out.println("Soy " + nombre + " en (" + x + ", " + y + ")");
    }
}