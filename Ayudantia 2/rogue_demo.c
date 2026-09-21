#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <termios.h>

#define MAP_WIDTH 20
#define MAP_HEIGHT 10

// primero definimos nuestras estructuras para el mapa y la posicion del jugador
typedef struct {
    int x;
    int y;
} Position;

typedef struct {
    char **grid;
    int width;
    int height;
} Map;

Map *create_map(int width, int height) {
    Map *map = malloc(sizeof(Map));
    if (!map) return NULL;

    map->width = width;
    map->height = height;

    map->grid = malloc(height * sizeof(char *));
    if (!map->grid) {
        free(map);
        return NULL;
    }

    for (int i = 0; i < height; i++) {
        map->grid[i] = malloc(width * sizeof(char));
        if (!map->grid[i]) {
            for (int j = 0; j < i; j++) free(map->grid[j]);
            free(map->grid);
            free(map);
            return NULL;
        }
        memset(map->grid[i], '.', width);
    }

    return map;
}

void destroy_map(Map *map) {
    if (!map) return;
    for (int i = 0; i < map->height; i++) {
        free(map->grid[i]);
    }
    free(map->grid);
    free(map);
}

void init_map(Map *map) {
    for (int y = 0; y < map->height; y++) {
        for (int x = 0; x < map->width; x++) {
            if (y == 0 || y == map->height - 1 || x == 0 || x == map->width - 1) {
                map->grid[y][x] = '#';
            } else {
                map->grid[y][x] = '.';
            }
        }
    }
}

void render_map(Map *map, Position *player) {
    system("clear");
    for (int y = 0; y < map->height; y++) {
        for (int x = 0; x < map->width; x++) {
            if (player->x == x && player->y == y) {
                printf("@");
            } else {
                printf("%c", map->grid[y][x]);
            }
        }
        printf("\n");
    }
    printf("Posicion: (%d, %d) | WASD para mover, Q para salir\n", player->x, player->y);
}

int is_valid_move(Map *map, int new_x, int new_y) {
    if (new_x < 0 || new_x >= map->width || new_y < 0 || new_y >= map->height) {
        return 0;
    }
    return map->grid[new_y][new_x] != '#';
}

void move_player(Position *player, Map *map, char input) {
    int new_x = player->x;
    int new_y = player->y;

    switch (input) {
        case 'w': case 'W': new_y--; break;
        case 's': case 'S': new_y++; break;
        case 'a': case 'A': new_x--; break;
        case 'd': case 'D': new_x++; break;
        default: return;
    }

    if (is_valid_move(map, new_x, new_y)) {
        player->x = new_x;
        player->y = new_y;
    }
}

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

int main() {
    Map *map = create_map(MAP_WIDTH, MAP_HEIGHT);
    if (!map) {
        fprintf(stderr, "Error: No se pudo crear el mapa\n");
        return 1;
    }

    init_map(map);

    Position *player = malloc(sizeof(Position));
    if (!player) {
        destroy_map(map);
        fprintf(stderr, "Error: No se pudo crear el jugador\n");
        return 1;
    }
    player->x = MAP_WIDTH / 2;
    player->y = MAP_HEIGHT / 2;

    char input;
    printf("=== Rogue Demo - Teorema Imperativo ===\n");
    printf("Controles: WASD para mover, Q para salir\n");
    printf("Presiona cualquier tecla para comenzar...\n");
    get_input();

    while (1) {
        render_map(map, player);
        input = get_input();

        if (input == 'q' || input == 'Q') {
            break;
        }

        move_player(player, map, input);
    }

    free(player);
    destroy_map(map);
    printf("\nJuego terminado. Memoria liberada correctamente.\n");

    return 0;
}