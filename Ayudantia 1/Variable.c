#include <stdio.h>
#include <stdlib.h>


struct estructura
{
    int numero;
    char caracter;
    /* data */
};

// segmentos fuera de la funcion (global) DATA y BSS
int global_inicializada = 42;
static int static_global = 10;
//BSS
int global_sin_inicializar;

void funcion_ejemplo() {
    // Ejemplo de static dentro de una funcion (vive en DATA)
    static int contador = 0;
    contador++;
    printf("contador = %d (dirección: %p)\n", contador, (void*)&contador);
}

int main(void) {
    // variables de STACK
    int variable_stack = 5;
    int arreglo_stack[5];

    // variable de HEAP
    int *puntero_heap = malloc(100 * sizeof(int));
    // El punteor vive en el STACK, pero el bloque de memoria al que apunta vive en el HEAP
    // puntero -> STACK
    // dato en memoria -> HEAP

    // variable constante por lo que es READ-ONLY viviendo el string en .rodata
    const char *literal = "Hola";

    // prints direcciones de memoria
    printf("Stack local:   %p\n", (void*)&variable_stack);
    printf("Stack arreglo: %p\n", (void*)arreglo_stack);
    printf("Heap:          %p\n", (void*)puntero_heap);
    printf("Data (global): %p\n", (void*)&global_inicializada);
    printf("BSS:           %p\n", (void*)&global_sin_inicializar);
    printf("Rodata:        %p\n", (void*)literal);

    // prints valores
    printf("Valor Stack local:  %d\n", variable_stack);
    printf("Valor Stack arreglo: \n");
    for (int i = 0; i < 5; i++) {
        arreglo_stack[i] = i + 1;
    }
    for (int i = 0; i < 5; i++){
        printf("indice %d: %d \n", i, arreglo_stack[i]);
    }
    *puntero_heap = 10;
    printf("Valor Heap:          %d\n", *puntero_heap);
    printf("Valor Data (global): %d \n", global_inicializada);
    printf("Valor BSS:           %d\n", global_sin_inicializar);
    printf("Valor Rodata:        %s\n", literal);

    funcion_ejemplo();
    funcion_ejemplo();

    printf("int: %d\n", sizeof(int));
    printf("char: %d\n", sizeof(char));

    free(puntero_heap);

    return 0;
}