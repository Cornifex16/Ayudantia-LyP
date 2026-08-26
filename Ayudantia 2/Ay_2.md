# Ayudantia 2 (26/08)

## Actividad

Debe realizar un mini tablero en C,usando structs, matrices y doble punteros. El resultado final debe verse de la siguiente manera o similar:

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

uno debe ser capaz de mover el objeto ```@``` con el teclado, para esto se usan la libreria ```termios``` para el movimiento.

Pueden usar este trozo de codigo, que detecta el teclado:

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