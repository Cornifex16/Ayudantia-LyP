#include <stdlib.h>
#include <stdio.h>
#include <time.h>


// identifique en que parte de la memoria se guarda que cosa en este codigo.
int P1() {
    srand(time(NULL));
    int *arr = malloc(10 * sizeof(int));
    if (!arr) {
        fprintf(stderr, "Error al asignar memoria\n");
        return 1;
    }

    for (int i = 0; i < 10; i++) {
        arr[i] = rand() % 100;
    }

    printf("Array generado: ");
    for (int i = 0; i < 10; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    free(arr);
    return 0;
}

// arregle bajo el paradigma estructurado el siguiente codigo, y explique que cambios realizo y porque.
// notar que el codigo tiene errores, es su trabajo identificar cuales son.
void P2() {
    int arr[10];
    int index = 0;
agregar:
    arr[index] = rand() % 100;
    index++;
    goto agregar;

    printf("Array generado: ");
imprimir:
    printf("%d, ", arr[index]);
    index++;
    goto imprimir;
    printf("\n");
}