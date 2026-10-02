// Jugador.java - Subclase concreta de Personaje

package ayudantia5;

/**
 * Jugador: implementa los pasos del template method.
 * - Movimiento: diagonal constante
 * - Energía: aleatoria (-1 a +3, puede ganar)
 * - Saludo: posición actual
 */
public class Jugador extends Personaje {
    public Jugador(String nombre, int x, int y, int energia) {
        super(nombre, x, y, energia);
    }

    @Override
    protected void moverse() {
        x++;  // Movimiento constante diagonal
        y++;
    }

    @Override
    protected void gastarEnergia() {
        // Cambio aleatorio entre -1 y 3
        int cambio = (int)(Math.random() * 5) - 1;
        setEnergia(getEnergia() - cambio);
        if (cambio < 0) System.out.println("  ¡Gané energía!");
    }

    @Override
    protected void saludar() {
        System.out.println("Soy " + nombre + " en (" + x + ", " + y + ")");
    }
}