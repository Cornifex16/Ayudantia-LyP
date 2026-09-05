#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// ERROR 1: Memory leak - no se libera la memoria asignada
char* crear_saludo(const char* nombre) {
    char* saludo = (char*)malloc(50 * sizeof(char));
    sprintf(saludo, "Hola %s, bienvenido!", nombre);
    return saludo;
}

// ERROR 2: Uso de memoria después de free
void procesar_datos(int* datos, int tamano) {
    for (int i = 0; i < tamano; i++) {
        datos[i] = i * 2;
    }
    free(datos);
    printf("Primer dato: %d\n", datos[0]);
}

// ERROR 3: Doble free
void liberar_memoria(int* ptr) {
    if (ptr != NULL) {
        free(ptr);
        free(ptr);
    }
}

// ERROR 4: Puntero no inicializado
int* buscar_elemento(int* arreglo, int tamano, int objetivo) {
    int* resultado; // ERROR: Puntero no inicializado
    for (int i = 0; i < tamano; i++) {
        if (arreglo[i] == objetivo) {
            resultado = &arreglo[i];
            break;
        }
    }
    return resultado;
}

// ERROR 5: No se verifica si malloc retorna NULL
double* crear_arreglo(int n) {
    double* arr = (double*)malloc(n * sizeof(double));
    // Falta: verificar si arr == NULL
    for (int i = 0; i < n; i++) {
        arr[i] = i * 1.5;
    }
    return arr;
}

// ERROR 6: Puntero colgante
void dangling_pointer(void) {
    int *p = 10;
    {
        int local = 5;
        p = &local;
    }
    printf("Valor de p: %d\n", *p);
}

int main() {
    // Prueba de crear_saludo
    char* mensaje = crear_saludo("Carlos");
    printf("%s\n", mensaje);
    
    // Prueba de procesar_datos
    int* nums = (int*)malloc(3 * sizeof(int));
    procesar_datos(nums, 3);
    
    // Prueba de liberar_memoria
    int* temp = (int*)malloc(sizeof(int));
    *temp = 42;
    liberar_memoria(temp);
    
    // Prueba de buscar_elemento
    int datos[] = {10, 20, 30, 40, 50};
    int* encontrado = buscar_elemento(datos, 5, 30);
    if (encontrado != NULL) {
        printf("Encontrado: %d\n", *encontrado);
    }
    
    // Prueba de crear_arreglo
    double* valores = crear_arreglo(5);
    for (int i = 0; i < 5; i++) {
        printf("%.1f ", valores[i]);
    }
    printf("\n");
    free(valores);

    // Prueba de dangling_pointer
    dangling_pointer();
    
    return 0;
}
