#include "calculadora.h"
#include <stdio.h>

void ejecutar_operacion(double (*op)(double, double), const char *nombre, Operandos ops) {
    double resultado = op(ops.a, ops.b);
    imprimir_resultado(nombre, resultado);
}

int main() {
    Operandos ops = {15.5, 3.2};

    printf("=== Calculadora Modular ===\n");
    printf("Operandos: %.2f, %.2f\n\n", ops.a, ops.b);

    ejecutar_operacion(sumar, "Suma", ops);
    ejecutar_operacion(restar, "Resta", ops);
    ejecutar_operacion(multiplicar, "Multiplicacion", ops);

    if (es_division_valida(ops.b)) {
        ejecutar_operacion(dividir, "Division", ops);
    } else {
        printf("Division: Error - divisor cero\n");
    }

    return 0;
}