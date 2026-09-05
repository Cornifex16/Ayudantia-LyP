#include <stdio.h>
#include <stdlib.h>

int global = 100;

// ERROR 1: Variable local sombrea variable global
void funcion_a() {
    int global = 50; // Sombrea la global
    printf("En funcion_a: global = %d\n", global);
}

// ERROR 2: Variable estática con valor inesperado en cada llamada (error logico)
void funcion_b() {
    static int contador = 0;
    contador++;
    printf("Contador: %d\n", contador);
}

// ERROR 3: Llamada a valor de variable local fuera de su alcance
int* funcion_c() {
    int local = 42;
    return &local;
}

// ERROR 4: Variable usada sin inicializar
void funcion_d() {
    int x;
    int y = 10;
    if (y > 5) {
        x = 20;
    }
    printf("x = %d\n", x); // x podría basura si y <= 5
}

int main() {
    // Prueba de funcion_a
    funcion_a();
    printf("Global en main: %d\n", global);
    
    // Prueba de funcion_b (3 llamadas)
    funcion_b();
    funcion_b();
    funcion_b();
    
    // Prueba de funcion_c
    int* ptr = funcion_c();
    // ERROR: ptr apunta a memoria inválida
    printf("Valor apuntado: %d\n", *ptr);
    
    // Prueba de funcion_d
    funcion_d();
    
    return 0;
}
