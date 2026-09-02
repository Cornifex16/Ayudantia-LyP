#ifndef CALCULADORA_H
#define CALCULADORA_H

typedef struct {
    double a;
    double b;
} Operandos;

double sumar(double a, double b);
double restar(double a, double b);
double multiplicar(double a, double b);
double dividir(double a, double b);
int es_division_valida(double divisor);
void imprimir_resultado(const char *operacion, double resultado);

#endif