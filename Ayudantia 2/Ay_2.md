# Ayudantia 2 (26/08)

## Actividad

Debe realizar un mini tablero en C,usando structs, matrices y doble punteros. El resultado final debe verse de la siguiente manera o similar:
```
####################
#..................#
#..................#
#..................#
#..................#
#.........@........#
#..................#
#..................#
#..................#
####################
```
## Bonus
uno debe ser capaz de mover el objeto ```@``` con el teclado, para esto se usan la libreria ```termios``` para el movimiento.

Pueden usar este trozo de codigo, que detecta el teclado:
```
char get_input() {
    struct termios oldt, newt;
    char ch;
    tcgetattr(STDIN_FILENO, &oldt);
    newt = oldt;
    newt.c_lflag &= ~(ICANON | ECHO);
    tcsetattr(STDIN_FILENO, TCSANOW, &newt);
    ch = getchar();
    tcsetattr(STDIN_FILENO, TCSANOW, &oldt);
    return ch;
}
```

## Arrays en C

Siguiendo lo visto sobre memoria en C, uno puede almacenar listas de objetos mediante punteros, se realiza de la siguiente manera
```char *lista_3 = malloc(3 * sizeof(char));```. Creando una lista de 3 posibles elementos tipo char.

Esto quiere decir que guarda 3 bytes de memoria, podemos decir que guarda desde la direccion 0x01 hasta 0x03, siendo cada una de estas direcciones de memoria un caracter almacenado en la lista. Ademas la primera direccion de memoria de la lista es la direccion de memoria a la que apunta ```lista_3```

**Nota**: Considerar que como las distintas estructuras de datos tienen distintos tamaños, al hacer una lista ocupan distintos tamaños, siendo una lista de 3 elementos char, 3 bytes y otra de 3 elementos int, 12 bytes (i.e. [0x00, 0x04, 0x08])

## Matrices en C

Ahora cuando hablamos de matrices generalmente hablamos de listas de listas o listas anidadas, esto sigue siendo igual en C, la diferencia es que ahora añadimos los punteros. Ya vimos que las listas en C son finalmente una lista de direcciones de memoria, osea punteros que apuntan a un valor; entonces cuando nosotros queremos hacer una lista dentro de otrs simplemente hacemos que esa direccion de memoria sea un puntero a otra lista.

Como ejemplo practico usaremos el siguiente codigo.
```
char **grilla = malloc(3 * sizeof(char *));
    // verificacion de existencia estandar y liberacion de memoria
    if (!grilla) {
        free(grilla);
        return NULL;
    }

    for (int i = 0; i < 3; i++) {
        grilla[i] = malloc(3 * sizeof(char));
        if (!grilla[i]) {
            // verificacion de existencia estandar y liberacion de memoria retroactiva
            for (int j = 0; j < i; j++) free(grilla[j]);
            free(grilla);
            return NULL;
        }
        memset(grilla[i], '.', 3);
    }
```

la linea char ```**grilla = malloc(3 * sizeof(char *));``` nos entrega nuestras primeras dimensiones en memoria, notar que empezamos con doble puntero, esto le indica al compilador que estamos armando una lista de listas. Tambien notar que el ```sizeof(char *)``` no esta dando el tamaño de un char normal, sino que esta dando el tamaño de un puntero de char, esto porque los elementos que estamos guardando en memoria son punteros, no valores de char.

Una vez establecida esta primera lista vacia la empezamos a llenar con punteros en vez de elementos, la razon de esta linea ```char *grilla[i] = malloc(3 * sizeof(char));```, que reserva un espacion de memoria equivalente a 3 bytes y guarda su puntero dentro de la direccion ```i``` en la primera lista creada

**Nota**: ```memset(grilla[i], '.', 3);``` esta linea de codigo solo se usa para rellenar rapidamente la lista en vez de hacer un ciclo for.

Esto se puede visualizar de la siguiente manera, tenemos nuestra grilla inicial, grilla = [0x00, 0x03, 0x03, 0x06]. En donde cada direccion de memoria apunta a otra lista en memoria, como ya indicamos un puntero de una lista es simplemente la direccion de su primer elemento.

Entonces grilla[0] = 0x00 = [0x00, 0x01, 0x02], Siendo cada direccion un caracter, de esta manera es que se puede hacer una matriz o grilla. Una vizualizacion completo de esto seria del tipo:

| 0x00 | 0x01 | 0x02 |

| 0x03 | 0x04 | 0x05 |

| 0x06 | 0x07 | 0x08 |

Una matriz de direcciones de memoria, donde cada una es un caracter.