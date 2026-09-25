#ifndef RNG_H
#define RNG_H

#include <stdint.h>
#include <limits.h>


// ambos usan una semilla, si quieren que cambie usen el tiempo local, tambien se puede dejar fija

// uint64_t rng = time(NULL); esta es una forma de obtener una semilla

// Generador splitmix64
static inline uint64_t splitmix64(uint64_t *x) {
    uint64_t z = (*x += 0x9e3779b97f4a7c15ULL);
    z = (z ^ (z >> 30)) * 0xbf58476d1ce4e5b9ULL;
    z = (z ^ (z >> 27)) * 0x94d049bb133111ebULL;
    return z ^ (z >> 31);
}

// Entero uniforme en [0, n-1] sin sesgo
static inline uint32_t rand_uniform(uint64_t *rng, uint32_t n) {
    uint64_t x, bound = (UINT64_MAX / n) * n;
    do {
        x = splitmix64(rng);
    } while (x >= bound);
    return (uint32_t)(x % n);
}

#endif