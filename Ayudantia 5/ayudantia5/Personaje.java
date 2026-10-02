// Personaje.java - Template Method Pattern (Clase Abstracta)
// Conceptos: abstract class, final method (template), abstract methods (pasos)

package ayudantia5;

/**
 * Personaje: clase abstracta con TEMPLATE METHOD.
 * 
 * TEMPLATE METHOD PATTERN:
 * - simular() es FINAL: define el ESQUELETO del algoritmo (no se puede cambiar)
 * - moverse(), gastarEnergia(), saludar() son ABSTRACTOS: cada subclase define SU comportamiento
 * - Ventaja: reutiliza el flujo principal, permite variar pasos específicos
 */
public abstract class Personaje {
    protected String nombre;
    protected int x, y;
    private int energia;  // Encapsulado con validación (como property en Python)

    public Personaje(String nombre, int x, int y, int energia) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.energia = Math.max(0, energia);
    }

    // Getter/Setter con validación (equivalente a @property en Python)
    public int getEnergia() { return energia; }
    public void setEnergia(int e) { this.energia = Math.max(0, e); }

    // TEMPLATE METHOD: final = no sobrescribible
    // Define el algoritmo: saludar -> moverse -> gastar energía (repetir hasta energía=0)
    public final void simular() {
        while (energia > 0) {
            saludar();       // Paso abstracto
            moverse();       // Paso abstracto
            gastarEnergia(); // Paso abstracto
        }
        System.out.println("Perdí toda mi energía :(");
    }

    // Métodos abstractos: OBLIGATORIOS en subclases
    protected abstract void moverse();
    protected abstract void gastarEnergia();
    protected abstract void saludar();
}