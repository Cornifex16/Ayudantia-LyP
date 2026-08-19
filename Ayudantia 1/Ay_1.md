# Ayudantia 1 (19/08)

Comando para compilar el codigo: ```gcc Variable.c -o variable```

Comando para ejecutar el codigo: ```./variable```

## Datos en Memoria
Dentro de la memoria los datos se almacenan en cierto orden. Esto define las caracteristicas de los datos, ademas de que tan rapido se puede acceder a ellos, una representacion tradicional seria la siguiente

![Imagen segmentos de datos](https://media.geeksforgeeks.org/wp-content/uploads/20250122155858092295/Memory-Layout-of-C-Program.webp)

En donde la direccion de memoria mas baja y cercana a la cpu es la de texto, en donde se guarda el script del codigo; mientras que el stack es lo mas alejado, donde se guardan las variables temporales usadas dentro de las funciones. Las secciones tienen cada una un puntero interno que les permite moverse entre ellas de manera agil.
### Data y BSS
Partiendo desde la seccion Data, tambien conocida como .data o initialized data esta es donde se almacenan las variables globales, osea que existen fuera de las funciones y permanecen entre procesos, como las variables ```static```. Luego esta la seccion BSS, esta es similar a la seccion Data, pero son variables no inicializadas, osea que no tienen un valor al crearlas.
### Heap

**Mea culpa**: Cometi un error en la ayudantia al señalar al heap como una estructura de arbol binaria, de la misma manera eso hace que no sea un registro mas rapido que el stack, pero si es un registro mas grande que el stack.

La seccion del Heap es una de las mas importantes en C, ya que tiene mayor tamaño y es donde se reservan los datos de los punteros al crearlos con malloc u otros. El heap no tiene una estructura de organizacion definida y es dependiente del programador y el OS a la hora de manejarlo.
### Stack
La seccion del stack es donde se guardan las variables dentro de una funcion, ademas que se guardan los punteros en ese segmento (ejemplo de puntero: 0xffffffff) y las direcciones de las llamadas de funcion con sus parametros. Sigue una organizacion LIFO, siendo rapido en su ejecucion.

## Manejo de memoria

Para manejar la memoria de manera efectiva en C uno tiene que tener en cuenta como se esta guardando y el tamaño de espacio que se usa segun el tipo de dato

### Tamaños tipos de datos

| tipo de dato | Tamaño(Bytes) |
| --- | --- |
| int | 4 |
| char | 1 |
| float | 4 |
| double | 8 |

### alocar la memoria
Uno para poder alocar memoria en C tiene que usar la funcion ```malloc```, esto abre un espacio de memoria y la reserva exclusivamente para esa variable, el argumento que se le entrega al ```malloc``` define que tanto espacio de memoria se reserva, medido siempre en bytes. En caso de usar una estructura de datos personalizada 'aka' ```struct``` entonces uno reserva memoria del tamaño de la suma de sus componentes.

IMPORTANTE: si se usa ```malloc``` entonces siempre se tiene que liberar la memoria con ```free``` sino se puede caer en errores de memory leak, causando que ocupe espacio en memoria incluso cuando termine el proceso. De la misma manera hay que tener cuidado en el traspaso de punteros, si se realiza de manera incorrecta y se pierde la direccion de memoria entonces queda un puntero vacio y los datos huerfanos.

## Recursos adicionales
[vision general segmentos de datos](https://www.geeksforgeeks.org/c/memory-layout-of-c-program/)

[vision detallada de DATA y BSS](https://medium.com/@johnehk86/66-what-are-memory-and-sections-text-data-bss-rodata-etc-e134bd5b9ccd)

[Repositorio de ejemplo de una simulacion en C](https://github.com/Cornifex16/Din-mica-de-minor-a-en-grafos-no-completos.git)