# Juego Shatranj

El proyecto Shatranj recrea el antiguo juego de ajedrez persa, considerado uno de los precursores del ajedrez moderno. Esta implementación en Java permite a dos jugadores enfrentarse en un juego de estrategia, siguiendo las reglas tradicionales del Shatranj.

## Características

- Juego de dos jugadores en consola.
- Implementación de las reglas tradicionales del Shatranj.
- Control de movimientos legales e ilegales.
- Chequeo de situaciones de Jaque y Jaque Mate.

#### Ejemplo del Tablero ASCII
```plaintext
   a b c d e f g h
 +-----------------+
8| R F E M X E F R |8
7| B B B B B B B B |7
6| . . . . . . . . |6
5| . . . . . . . . |5
4| . . . . . . . . |4
3| . . . . . . . . |3
2| b b b b b b b b |2
1| r f e m x e f r |1
 +-----------------+
   a b c d e f g h

Turno de Blanco (minúsculas)
Posicion ORIGEN (ejemplo: 8b): 
2a
Posicion DESTINO (ejemplo: 6c): 
3a

```

## Inicio Rápido

Para comenzar a jugar Shatranj, clona este repositorio y compila el código:

```bash
git clone https://github.com/cosmincaliin/Shatranj-On-Java.git
cd shatranj
javac Shatranj.java
java Shatranj
```

## Cómo Jugar

El juego se juega en la consola, y los jugadores introducen sus movimientos en notación algebraica simplificada (por ejemplo, "2a" "Intro" "3a" para mover una pieza de la casilla 2a a la casilla 3a).

### Movimientos

Aquí tienes una guía rápida de cómo mover cada pieza:

| Pieza       | Notación | Descripción                                         |
|-------------|----------|-----------------------------------------------------|
| Baidaq (B)  | B        | Mueve una casilla hacia adelante, captura en diagonal |
| Ruhk (R)    | R        | Mueve en línea recta horizontal o vertical          |
| Faras (F)   | F        | Mueve en forma de "L"                              |
| Elefante (E)| E        | Mueve dos casillas en diagonal sin saltar          |
| Ministro (M)| M        | Mueve una casilla en diagonal                      |
| Xa (X)      | X        | Mueve una casilla en cualquier dirección           |

### Ejemplo de Partida

```plaintext
2d
3d
7d
6d
1b
3c
8b
6c
```

## Desarrollo

Este proyecto ha sido desarrollado con el objetivo de proporcionar una implementación digital de Shatranj que sea fiel a las reglas originales del juego. Agradecemos cualquier contribución, ya sea en forma de nuevas características, correcciones de errores o mejoras en la documentación.

## Contribuir

Si deseas contribuir al proyecto, por favor lee `CONTRIBUTING.md` para más información sobre cómo enviar pull requests. Nos entusiasma recibir contribuciones de todos, y hay muchas maneras de ayudar, desde mejorar la documentación hasta agregar nuevas funcionalidades o reportar bugs.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo `LICENSE` para más detalles. Esto significa que tienes amplia libertad para distribuir, modificar, incluir en proyectos privados o comerciales, siempre y cuando se incluya el reconocimiento original y se cumpla con los términos de esta licencia.

## Referencias

- [Historia del Shatranj](https://es.wikipedia.org/wiki/Shatranj)
- [Reglas del Shatranj](https://www.ancientchess.com/page/play-shatranj.htm)

Estas referencias ofrecen una visión general de la rica historia y las reglas del Shatranj, proporcionando un contexto valioso para este proyecto y ayudando a los usuarios y contribuyentes a comprender mejor las bases del juego.

## Agradecimientos

Agradecimientos especiales a todos los contribuyentes que han dedicado su tiempo y esfuerzo para hacer de este proyecto una realidad. Sin su dedicación y el apoyo de la comunidad de juegos de mesa, esto no habría sido posible.

Si tienes preguntas, sugerencias o deseas unirte a la conversación sobre el desarrollo de este proyecto, no dudes en contactarnos o abrir un issue en el repositorio de GitHub.

¡Esperamos que disfrutes jugando y explorando el mundo del Shatranj!
