#include <stdio.h>

int suma_hasta_n(int n) {
    int suma = 0;
    for (int i = 1; i <= n; i++) {
        suma += i;
    }
    return suma;
}

int factorial(int n) {
    int resultado = 1;
    while (n > 1) {
        resultado *= n;
        n--;
    }
    return resultado;
}

void clasificar_numero(int x) {
    if (x > 0) {
        printf("%d: Positivo\n", x);
    } else if (x < 0) {
        printf("%d: Negativo\n", x);
    } else {
        printf("%d: Cero\n", x);
    }
}

int main() {
    printf("Suma 1-10 (estructurado): %d\n", suma_hasta_n(10));
    printf("Factorial 5: %d\n", factorial(5));

    clasificar_numero(5);
    clasificar_numero(-3);
    clasificar_numero(0);

    return 0;
}