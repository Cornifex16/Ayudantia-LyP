// FurgonEscolar.java - Subclase (Especialización)
// Conceptos: extends, super(), @Override, atributos propios

package ayudantia5;

import java.util.ArrayList;
import java.util.List;

/**
 * FurgonEscolar ES UN Auto (herencia = relación IS-A).
 * Especializa el comportamiento y agrega funcionalidad propia.
 */
public class FurgonEscolar extends Auto {
    // Atributo PROPIO de esta subclase
    private List<String> pasajeros;

    /**
     * Constructor: usa super() para inicializar la parte de Auto
     */
    public FurgonEscolar(String marca, String modelo, int anio, String color, int km) {
        super(marca, modelo, anio, color, km);  // Llama a constructor de Auto
        this.pasajeros = new ArrayList<>();
    }

    // OVERRIDE: comportamiento ESPECIALIZADO
    @Override
    public void conducir(int kms) {
        System.out.println("Conduciendo CON CUIDADO " + kms + " km (lleva niños)");
        kilometraje += 2 * kms;  // Accede a atributo protected de Auto
    }

    // Método ESPECÍFICO de la subclase
    public void inscribirPasajero(String nombre) {
        pasajeros.add(nombre);
    }

    public List<String> getPasajeros() {
        return pasajeros;
    }
}