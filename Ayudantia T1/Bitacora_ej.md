# Ejemplo de Bitácora de Prompts

realizar una bitácora de prompts es relativamente sencillo y mecánico, les he preparado la siguiente plantilla con la que pueden rellenar la información de su bitácora de manera que sea mas legible. Recordar que como es bitácora esta ordenada de forma cronológica.

**Tip**: les recomiendo ir rellenando la bitácora mientras van usando herramienta de inteligencia artificial, de esta manera la bitácora representa mejor el progreso de su trabajo y luego no tendrán que estar buscando entre registros de chats eternos.

## Plantilla

#### [modelo] [[numero de prompt]] ([fecha])

**Prompt**: ...

**Respuesta recibida**: ...

**Reflexión**: ...

**Deliberación**: ...

**Enlace a conversación(Opcional)**: ... 

## Ejemplo

#### Gemini flash 3.8 [1] (23:59 20-09-2026)

**Prompt**: explícame en un párrafo cuales son las variables en C y su tamaño en memoria

**Respuesta recibida**: En lenguaje C, las variables representan espacios reservados en memoria para almacenar datos bajo un tipo específico: char para caracteres (1 byte), int para números enteros (habitualmente 4 bytes en sistemas modernos, aunque puede ser 2 bytes según la arquitectura), variantes enteras como short (al menos 2 bytes) y long / long long (generalmente 4 u 8 bytes), y tipos para números con punto flotante como float (precisión simple, 4 bytes) y double (doble precisión, 8 bytes, o long double de 8 a 16 bytes); su tamaño exacto no está rígidamente fijado por el estándar sino condicionado por la arquitectura del procesador y el compilador, por lo que siempre se determina de forma precisa mediante el operador sizeof.

**Reflexión**: La respuesta es completa y me entrega todo lo que pedí, me queda mas cuales son las variables en C y sus tamaños. Ademas es util que me de las herramientas para averiguarlo por mi cuenta

**Deliberación**: implemento lo que me entrega la IA en mi informe.

[Enlace a conversación](https://share.gemini.google/KSlPLGsygAfC)