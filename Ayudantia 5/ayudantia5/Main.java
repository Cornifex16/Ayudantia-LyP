// Main.java - Programa principal: integra todos los ejemplos
// IMPORTANTE: usa importaciones del paquete ayudantia5

package ayudantia5;

// Importaciones explícitas (buena práctica)
// import ayudantia5.Persona;
// import ayudantia5.CuentaBancaria;
// import ayudantia5.Auto;
// import ayudantia5.FurgonEscolar;
// import ayudantia5.Figura;
// import ayudantia5.Circulo;
// import ayudantia5.Rectangulo;
// import ayudantia5.Triangulo;
// import ayudantia5.Personaje;
// import ayudantia5.Jugador;
// import ayudantia5.Enemigo;
// import ayudantia5.Base;
// import ayudantia5.SubClaseA;
// import ayudantia5.SubClaseB;

// O usar importación wildcard (menos recomendada para proyectos grandes)
// import ayudantia5.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   DEMO: PROGRAMACIÓN ORIENTADA A OBJETOS");
        System.out.println("========================================\n");

        demoClasesYObjetos();
        demoEncapsulamiento();
        demoHerencia();
        demoPolimorfismo();
        demoClasesAbstractasFiguras();
        demoTemplateMethod();
        demoBaseMixta();
    }

    // ---------------------------------------------------------
    // 1. CLASES Y OBJETOS
    // ---------------------------------------------------------
    static void demoClasesYObjetos() {
        System.out.println("--- 1. CLASES Y OBJETOS ---");

        Persona p1 = new Persona("Ana", 25);
        Persona p2 = new Persona("Carlos", 30);

        p1.saludar();
        p2.saludar();

        System.out.println("Persona 1: " + p1.getNombre() + ", " + p1.getEdad() + " años");
        System.out.println("Persona 2: " + p2.getNombre() + ", " + p2.getEdad() + " años");

        p1.setEdad(26);
        p2.setEdad(0);
        System.out.println("Después de setEdad(26): " + p1.getNombre() + ", " + p1.getEdad() + " años");

        p1.setEdad(-5);  // Validación rechaza
        System.out.println("Después de setEdad(-5): " + p1.getNombre() + ", " + p1.getEdad() + " años\n");
    }

    // ---------------------------------------------------------
    // 2. ENCAPSULAMIENTO
    // ---------------------------------------------------------
    static void demoEncapsulamiento() {
        System.out.println("--- 2. ENCAPSULAMIENTO: CuentaBancaria ---");
        
        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 1000);
        System.out.println("Titular: " + cuenta.getTitular() + " | Saldo: $" + cuenta.getSaldo());

        cuenta.depositar(500);
        System.out.println("Depositar 500 -> Saldo: $" + cuenta.getSaldo());

        cuenta.retirar(200);
        System.out.println("Retirar 200 -> Saldo: $" + cuenta.getSaldo());

        cuenta.retirar(2000);  // Fallido: fondos insuficientes
        System.out.println("Retirar 2000 -> Saldo: $" + cuenta.getSaldo() + "\n");
    }

    // ---------------------------------------------------------
    // 3. HERENCIA
    // ---------------------------------------------------------
    static void demoHerencia() {
        System.out.println("--- 3. HERENCIA: Auto -> FurgonEscolar ---");

        Auto auto = new Auto("Suzuki", "Vitara", 2015, "Naranjo", 35000);
        FurgonEscolar furgon = new FurgonEscolar("Kia", "Sportage", 2000, "Blanco", 135000);

        System.out.println("Auto (superclase):");
        auto.mostrarInfo();
        auto.conducir(12);
        System.out.println("Kilometraje: " + auto.leerOdometro());

        System.out.println("\nFurgonEscolar (subclase):");
        furgon.mostrarInfo();           // Heredado de Auto
        furgon.conducir(5);             // Sobrescrito (@Override)
        System.out.println("Kilometraje: " + furgon.leerOdometro());  // Heredado

        furgon.inscribirPasajero("Benjita");
        furgon.inscribirPasajero("Enzito");
        System.out.println("Pasajeros: " + furgon.getPasajeros() + "\n");
    }

    // ---------------------------------------------------------
    // 4. POLIMORFISMO
    // ---------------------------------------------------------
    static void demoPolimorfismo() {
        System.out.println("--- 4. POLIMORFISMO ---");
        
        Auto auto = new Auto("Suzuki", "Vitara", 2015, "Naranjo", 35000);
        FurgonEscolar furgon = new FurgonEscolar("Kia", "Sportage", 2000, "Blanco", 135000);

        // Array de tipo superclase contiene subclases
        Auto[] flota = {auto, furgon};
        
        System.out.println("Mismo mensaje (conducir(10)), comportamiento distinto:");
        for (Auto a : flota) {
            a.conducir(10);  // Binding dinámico: cada uno su versión
        }
        System.out.println();
    }

    // ---------------------------------------------------------
    // 5. CLASES ABSTRACTAS: FIGURAS
    // ---------------------------------------------------------
    static void demoClasesAbstractasFiguras() {
        System.out.println("--- 5. CLASES ABSTRACTAS: Figuras Geométricas ---");
        
        Figura[] figuras = {
            new Circulo(5),
            new Rectangulo(4, 6),
            new Triangulo(3, 4)
        };

        for (Figura f : figuras) {
            System.out.println(f.getClass().getSimpleName() +
                ": área = " + f.calcularArea() +
                ", perímetro = " + f.calcularPerimetro());
        }
        System.out.println();
    }

    // ---------------------------------------------------------
    // 6. TEMPLATE METHOD
    // ---------------------------------------------------------
    static void demoTemplateMethod() {
        System.out.println("--- 6. TEMPLATE METHOD: Personaje -> Jugador/Enemigo ---");
        
        System.out.println(">>> JUGADOR:");
        Personaje jugador = new Jugador("Javiera", 0, 0, 10);
        jugador.simular();  // Ejecuta template method

        System.out.println("\n>>> ENEMIGO:");
        Personaje enemigo = new Enemigo("Nicolás", 0, 0, 15);
        enemigo.simular();
        System.out.println();
    }

    // ---------------------------------------------------------
    // 7. BASE CON MÉTODOS CONCRETOS + ABSTRACTOS
    // ---------------------------------------------------------
    static void demoBaseMixta() {
        System.out.println("--- 7. BASE MIXTA: Concreto + Abstracto ---");
        
        Base b1 = new SubClaseA();
        Base b2 = new SubClaseB();

        System.out.println("SubClaseA:");
        b1.metodo1();  // Heredado de Base (concreto)
        b1.metodo2();  // Implementado en SubClaseA

        System.out.println("\nSubClaseB:");
        b2.metodo1();  // Heredado de Base (concreto)
        b2.metodo2();  // Implementado en SubClaseB
        System.out.println();
    }
}