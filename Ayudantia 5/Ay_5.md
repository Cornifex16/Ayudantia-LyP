# Ayudantía 5 - Programación Orientada a Objetos en Java

## Programación Orientada a Objetos (POO/OOP)

La **Programación Orientada a Objetos** es un paradigma donde los programas modelan funcionalidades mediante la interacción entre **objetos**. Un objeto combina:
- **Datos** (atributos/fields) - describen el estado
- **Comportamientos** (métodos) - representan acciones

Las **clases** son plantillas que definen atributos y métodos. **Instanciar** una clase = crear un objeto (instancia).

---

## POO en Java

```java
public class Persona {
    // Atributos (fields)
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método de instancia
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

// Uso:
Persona p1 = new Persona("Ana", 25);
p1.saludar();  // "this" es implícito en Java (no se escribe como 'self' en Python)
```

---

## Paquetes e Importaciones en Java

### ¿Qué es un paquete?
Un **paquete** (`package`) agrupa clases relacionadas, evita conflictos de nombres y controla acceso.

```java
// En la PRIMERA línea del archivo:
package ayudantia5;  // Define que esta clase pertenece al paquete 'ayudantia5'
```

### Estructura de directorios
El sistema de archivos DEBE reflejar la estructura del paquete:
```
Ayudantia5/
├── ayudantia5/
│   ├── Persona.java
│   ├── Auto.java
│   └── Main.java
```

### Compilar y ejecutar con paquetes
```bash
# Desde el directorio PADRE del paquete (Ayudantia5/):
javac ayudantia5/*.java
java -cp . ayudantia5.Main
```

### Importar clases de otros paquetes

```java
// 1. Importación explícita (RECOMENDADA)
import ayudantia5.Persona;
import ayudantia5.CuentaBancaria;

// 2. Importación wildcard (menos clara, evita en proyectos grandes)
import ayudantia5.*;

// 3. Nombre completamente calificado (sin import)
ayudantia5.Persona p = new ayudantia5.Persona("Ana", 25);
```

### Clases que NO requieren import (java.lang)
`String`, `System`, `Math`, `Integer`, `Double`, `Boolean`, `Object`, `Exception`, `Runnable`, etc.

### Modificadores de acceso y paquetes

| Modificador | Misma clase | Mismo paquete | Subclase (otro paquete) | Cualquier lugar |
|-------------|-------------|---------------|-------------------------|-----------------|
| `private`   | ✓           | ✗             | ✗                       | ✗               |
| *(default)* | ✓           | ✓             | ✗                       | ✗               |
| `protected` | ✓           | ✓             | ✓                       | ✗               |
| `public`    | ✓           | ✓             | ✓                       | ✓               |

> **Nota:** `protected` permite acceso a subclases aunque estén en otro paquete.

---

## Contenidos de la Ayudantía

### 1. Clases y Objetos (`Persona.java`)
- Definición de clase, atributos `private`, constructor
- Getters/Setters con validación
- Instanciación con `new`

### 2. Encapsulamiento (`CuentaBancaria.java`)
- Estado privado (`private`) + métodos públicos controlados
- Validaciones en lógica de negocio (depósito/retiro)
- Invariantes: saldo nunca negativo

### 3. Herencia (`Auto.java` → `FurgonEscolar.java`)
- `extends`: relación **IS-A** (FurgonEscolar ES UN Auto)
- `super()`: llamar constructor/métodos de la superclase
- `@Override`: sobrescribir comportamiento
- `protected`: acceso en subclases

### 4. Polimorfismo (`Main.java` - demoPolimorfismo)
- Variable de tipo superclase referencia objeto subclase
- **Binding dinámico**: JVM elige método según tipo real en runtime
- `Auto[] flota = {new Auto(...), new FurgonEscolar(...)}`

### 5. Clases Abstractas (`Figura.java`, `Circulo.java`, etc.)
- `abstract class`: no instanciable directamente
- Métodos `abstract`: contrato obligatorio para subclases concretas
- Pueden tener métodos concretos (compartidos)

### 6. Template Method (`Personaje.java`, `Jugador.java`, `Enemigo.java`)
- Método `final` (template) define esqueleto del algoritmo
- Métodos `abstract` (pasos) implementados por subclases
- Reutiliza flujo, permite variar comportamiento

### 7. Base Mixta (`Base.java`, `SubClaseA.java`, `SubClaseB.java`)
- Clase abstracta con métodos concretos + abstractos
- Hereda implementación + obliga a completar

---

## Archivos del Proyecto

```
Ayudantia5/
├── ayudantia5/
│   ├── Persona.java           # Clases y objetos
│   ├── CuentaBancaria.java    # Encapsulamiento
│   ├── Auto.java              # Superclase (herencia)
│   ├── FurgonEscolar.java     # Subclase (herencia)
│   ├── Figura.java            # Abstracta (figuras)
│   ├── Circulo.java
│   ├── Rectangulo.java
│   ├── Triangulo.java
│   ├── Personaje.java         # Template Method
│   ├── Jugador.java
│   ├── Enemigo.java
│   ├── Base.java              # Abstracta mixta
│   ├── SubClaseA.java
│   ├── SubClaseB.java
│   └── Main.java              # Demo principal
└── Ay_5.md
```

---

## Compilar y Ejecutar

```bash
cd Ayudantia5
javac ayudantia5/*.java
java -cp . ayudantia5.Main
```

---

## Conceptos Clave - Resumen

| Concepto | Palabra clave | Qué hace |
|----------|---------------|----------|
| Encapsulamiento | `private` + getters/setters | Oculta datos, valida acceso |
| Herencia | `extends` | Reutiliza y especializa |
| Constructor padre | `super(...)` | Inicializa parte heredada |
| Sobrescritura | `@Override` | Cambia comportamiento heredado |
| Polimorfismo | Superclase como tipo | Mismo msg, comportamiento distinto |
| Abstracción | `abstract class/method` | Contrato obligatorio |
| Template Method | `final` + `abstract` | Algoritmo fijo + pasos variables |
| Paquetes | `package` / `import` | Organiza y evita conflictos |

---

## Ejemplos Didácticos por Archivo

| Archivo | Concepto Principal | Qué Demuestra |
|---------|-------------------|---------------|
| `Persona.java` | Clases/Objetos | Constructor, getters/setters, validación |
| `CuentaBancaria.java` | Encapsulamiento | Lógica de negocio privada, invariantes |
| `Auto.java` / `FurgonEscolar.java` | Herencia | `extends`, `super()`, `@Override`, `protected` |
| `Figura.java` + hijos | Clase Abstracta | Contrato (área/perímetro), polimorfismo |
| `Personaje.java` + hijos | Template Method | `final simular()` + pasos abstractos |
| `Base.java` + hijos | Abstracta mixta | Métodos concretos heredados + abstractos |
| `Main.java` | Integración | Une todos los conceptos en demos |