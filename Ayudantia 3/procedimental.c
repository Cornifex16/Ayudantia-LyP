#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <inttypes.h>

void inicializar_semilla() {
    srand(time(NULL));
}

int generar_aleatorio(int min, int max) {
    return min + rand() % (max - min + 1);
}

void intercambiar(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void ordenar_burbuja(int *arr, int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                intercambiar(&arr[j], &arr[j + 1]);
            }
        }
    }
}

void imprimir_array(const int *arr, int n, const char *etiqueta) {
    printf("%s: [", etiqueta);
    for (int i = 0; i < n; i++) {
        printf("%d", arr[i]);
        if (i < n - 1) printf(", ");
    }
    printf("]\n");
}

int busqueda_binaria(const int *arr, int n, int objetivo) {
    int izq = 0, der = n - 1;
    while (izq <= der) {
        int medio = izq + (der - izq) / 2;
        if (arr[medio] == objetivo) return medio;
        if (arr[medio] < objetivo) izq = medio + 1;
        else der = medio - 1;
    }
    return -1;
}

void demostrar_procedimientos() {
    printf("=== Demostracion Procedural ===\n");
    inicializar_semilla();

    int numeros[10];
    for (int i = 0; i < 10; i++) {
        numeros[i] = generar_aleatorio(1, 100);
    }

    imprimir_array(numeros, 10, "Original");
    ordenar_burbuja(numeros, 10);
    imprimir_array(numeros, 10, "Ordenado");

    int buscar = generar_aleatorio(1, 100);
    int pos = busqueda_binaria(numeros, 10, buscar);
    if (pos >= 0) printf("Encontrado %d en indice %d\n", buscar, pos);
    else printf("%d no encontrado\n", buscar);
}

int main() {
    demostrar_procedimientos();
    _Float128 i = 10064897465498515587.5001234569874661;
    printf("%.20f",i);
    return 0;
}