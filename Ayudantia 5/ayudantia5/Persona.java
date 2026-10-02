// Persona.java - Clases y Objetos básicos
// Conceptos: clase, objeto, constructor, encapsulamiento básico (getters/setters)

package ayudantia5;

/**
 * Clase que representa una Persona.
 * Demuestra:
 * - Atributos privados (encapsulamiento)
 * - Constructor con validación
 * - Getters (lectura) y Setters (escritura con validación)
 */
public class Persona {
    // Atributos PRIVADOS: solo accesibles dentro de esta clase
    private String nombre;
    private int edad;
    private int dinero;

    /**
     * Constructor: inicializa el objeto.
     * Valida que la edad no sea negativa.
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = Math.max(0, edad);  // Validación: edad >= 0
        salario();
    }

    // Comportamiento
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    private void salario(){
        this.dinero = 100;
    }

    public int getSalario() { return  dinero; }

    // GETTERS: acceso de LECTURA controlado
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    // SETTERS: acceso de ESCRITURA controlado + VALIDACIÓN
    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("  [Validación] Edad debe ser > 0. Valor ignorado.");
        }
    }
}