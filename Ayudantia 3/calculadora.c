#include "calculadora.h"
#include <stdio.h>

double sumar(double a, double b) {
    return a + b;
}

double restar(double a, double b) {
    return a - b;
}

double multiplicar(double a, double b) {
    return a * b;
}

double dividir(double a, double b) {
    return a / b;
}

int es_division_valida(double divisor) {
    return divisor != 0.0;
}

void imprimir_resultado(const char *operacion, double resultado) {
    printf("%s = %.2f\n", operacion, resultado);
}