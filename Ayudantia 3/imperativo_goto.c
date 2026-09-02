#include <stdio.h>

int main() {
    int i = 1;
    int sum = 0;

inicio:
    if (i > 10) goto fin;
    sum += i;
    i++;
    goto inicio;

fin:
    printf("Suma 1-10 (con goto): %d\n", sum);

    int x = 5;
    if (x > 0) goto positivo;
    printf("Negativo\n");
    goto final;

positivo:
    printf("Positivo\n");

final:
    return 0;
}