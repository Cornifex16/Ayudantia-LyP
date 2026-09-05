#include <stdio.h>
#include <stdlib.h>

int* funcion_c() {
    int local = 42;
    return &local;
}

int main(){
    int * x = funcion_c();
    printf("%d \n", *x);
    
    int* p = malloc(sizeof(int));
    *p = 10;
    printf("%d \n", *p);
    printf("%d \n", p);
    {
        int local = 5;
        p = &local;
    }
    printf("%d \n", p);
    printf("%d \n", *p);
    free(p);
    return 0;
}