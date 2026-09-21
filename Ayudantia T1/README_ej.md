# Ejemplo de README

A lo largo del curso tendrán que realizar varias tareas que involucran crear código, para poder obtener una buena nota en estas evaluaciones es importante que ustedes sepan realizar un buen README.

Un README consiste en un archivo que explica brevemente como ejecutar su código y que es lo que hace, eso en el nivel mas básico, para este curso le añadimos que tenga que tener las decisiones de diseño y una descripción general de las funciones y estructuras implementadas.

Los README en github son escritos en formato markdown, que tiene formas especificas de darle estilo a lo que escribimos, pudiendo ordenar de mejor manera como comunicamos lo que hace el programa. Pueden ver las distintas funciones que tiene en este [link](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet).

Un buen README no tiene que ser muy extenso, tiene que ser **conciso** sin que le falte nada de la información. Por sobre todo tiene que ser claro y limpio, esto facilitara la revision de la tarea y que otras personas puedan entenderlo.

**Dejar claro lo que NO pudieron implementar y lo que no funciona a la perfección. Esto puede sonar innecesario pero permite que el ayudante se enfoque en lo que sí podría subir su puntaje.**

Ahora les dare la siguiente plantilla de como estructurar el README, pueden copiar, pegar y luego rellenar con su propia información. Recordar que esto es un **ejemplo**, osea que no tiene porque seguir este orden, pero tiene que contener la información detallada en el enunciado.

## Secciones

aquí pueden colocar hipervínculos a sus secciones, esto les sirve si su README termina siendo enorme.

- [Ejecucion](#compilación-y-ejecución)
- [controles](#como-jugar-o-usar)
- [Logrados](#implementaciones-y-faltantes)
- [librerias externas](#librerías-externas)
- [librerias internas](#librerías-creadas)
- [estructuras](#estructuras-propias)
- [decisiones de diseño](#decisiones-de-diseño-y-supuestos)
- [referencias](#referencias-de-código-externo)


## Compilación y Ejecución

Aquí colocan como ejecutar su código, ya sea los comandos específicos en terminal u otros. Ademas en caso de necesitar archivos adicionales por parte del usuario aquí se puede detallar que se necesita y donde almacenarlo. Por ejemplo:

1. Crea un archivo `.env` en la raíz del proyecto.
2. Añade las siguientes variables para usar VLLM (ajusta los valores según corresponda):

```env
VLLM_BASE_URL="http://<ip-del-servidor>:8000/v1"
VLLM_API_KEY="tu-api-key"
```

Para instalar las dependencias, crear el entorno virtual y preparar los datos, ejecuta el script de setup. **Solo necesitas correr esto una vez.**

```bash
chmod +x setup.sh
./setup.sh
```

Una vez realizado esto compilar y ejecutar con los siguiente comandos:

```
gcc main.c juego.c -o rogue
./rogue
```


## Como jugar o usar

En esta seccion especifican como el usuario interactúa con el programa, ya sea para una aplicación de juego o una herramienta es necesario explicitar las reglas. Por ejemplo:

#### Movimiento
- **W**: moverse hacia arriba una casilla
- **A**: moverse hacia abajo una casilla
- ...
#### Como ganar
- Se tiene que recolectar todas las monedas para completar un nivel
- Se tiene que completar el nivel en la menor cantidad de movimientos posibles
- ...

## Implementaciones y faltantes

Aquí pueden especificar que aspectos del enunciado lograron implementar y que aspectos no lograron implementar, esto sirve para agilizar la revision de las tareas por parte del ayudante, pudiendo centrarse en los aspectos que si se lograron en vez de los aspectos que no.

**Tip**: pueden usar esta sección como un organizador para su trabajo en equipo, marcando que aspectos están terminados y cuales faltan por trabajar

#### Aspectos logrados
- El programa usa el teclado para desplazarse
- El mapa se genera automáticamente con ciertas reglas procedurales
- hay monedas en el mapa

#### Aspectos no logrados
- El jugador no acumula puntos
- No hay ranking de puntos entre jugadores

## Librerías externas

En caso que la tarea permita usar librerías externas o alguna otra razón es bueno documentar el uso de estas librerías.

1. ```librería_1```: ```función() / módulo```
2. ```librería_2```: ```función() / módulo``` (debe instalarse)
3. ...

## Librerías creadas

Como las tareas son grandes es necesario modularizar, para poder facilitar entender que es lo que hace cada modulo aca se incluye todas las librerías creadas y una descripción de lo que hacen.

1. ```librería_1```: Contiene a ```ClaseA```, ```ClaseB```, (ser general, tampoco es necesario especificar cada una)...
2. ```librería_2```: Hecha para <insertar descripción **breve** de lo que hace o qué contiene>
3. ...

## Estructuras propias

De la misma manera que las librerías usadas, es buena idea mantener un registro de las estructuras usadas o clases, dependiendo del lenguaje, no se tiene que ser detallado sino dar una vision general de lo que hacen.

1. ```Estructura_1```: guarda los datos de posición en un mapa.
2. ```Clase_2```: Representa a un Pokemon, sus atributos y habilidades.
3. ...

## Decisiones de diseño y supuestos

Aca describen brevemente las decisiones de diseño que tomaron para hacer el programa, toda cosa que el enunciado dejo a libre elección tiene que estar explicitada en esta sección. Por ejemplo.

Suponiendo que el enfrentamiento entre dos jugadores se tiene que realizar en tiempo real, se decidió crear un modulo adicional que funcione como *lobby*, permitiendo crear una conexión persistente entre jugadores. Producto de esta decisiones añadimos ...

## Referencias de código externo

En caso de haber buscado código en internet, ya sea en stackoverflow u otros sitios, es importante también referenciarlo, igual que en la bitácora de prompts aquí se tiene que indicar mediante hipervínculo la pagina de donde extrajo el código y ademas explicar brevemente su implementación.

1. [w3schools output](https://www.w3schools.com/c/c_output.php): aquí saque código de referencia para poder realizar los outputs de mi tarea, visto en los archivos ...