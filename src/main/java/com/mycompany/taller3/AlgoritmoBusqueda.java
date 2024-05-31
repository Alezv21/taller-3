/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller3;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author PC
 */

public class AlgoritmoBusqueda {

    public static void main(String[] args) {
        int[] tamanos = {1000, 10000, 100000, 1000000};
        
        System.out.printf("%-10s %-15s %-15s %-25s\n", "N", "Tiempo Empirico", "Tiempo Estimado", "Relacion Empirico/Estimado");

        for (int N : tamanos) {
            int[] arreglo = generarArregloAleatorio(N);
            int[] valoresBusqueda = generarArregloAleatorio(N);

            // Búsqueda Secuencial
            long tiempoSecuencial = medirTiempoEjecucion(() -> {
                for (int valor : valoresBusqueda) {
                    busquedaSecuencial(arreglo, valor);
                }
            });
            double tiempoEstimadoSecuencial = N * N;
            double relacionSecuencial = (double) tiempoSecuencial / tiempoEstimadoSecuencial;
            
            // Búsqueda Binaria
            Arrays.sort(arreglo); // Ordenar el arreglo para la búsqueda binaria
            long tiempoBinario = medirTiempoEjecucion(() -> {
                for (int valor : valoresBusqueda) {
                    busquedaBinaria(arreglo, valor);
                }
            });
            double tiempoEstimadoBinario = N * Math.log(N) / Math.log(2);
            double relacionBinario = (double) tiempoBinario / tiempoEstimadoBinario;

            System.out.printf("%-10d %-15d %-15f %-25f\n", N, tiempoSecuencial, tiempoEstimadoSecuencial, relacionSecuencial);
            System.out.printf("%-10d %-15d %-15f %-25f\n", N, tiempoBinario, tiempoEstimadoBinario, relacionBinario);
        }
    }

    public static int[] generarArregloAleatorio(int tamano) {
        Random rand = new Random();
        int[] arreglo = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = rand.nextInt(tamano);
        }
        return arreglo;
    }

    public static int busquedaSecuencial(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public static int busquedaBinaria(int[] arreglo, int valor) {
        int bajo = 0;
        int alto = arreglo.length - 1;

        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (arreglo[medio] == valor) {
                return medio;
            } else if (arreglo[medio] < valor) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return -1;
    }

    public static long medirTiempoEjecucion(Runnable tarea) {
        long t1 = System.nanoTime();
        tarea.run();
        long t2 = System.nanoTime();
        return t2 - t1;
    }
}

/**
 respuestas
 Estimación del Costo O:

Búsqueda Secuencial: 𝑂(𝑁)
Búsqueda Binaria: 𝑂(log𝑁)

Coincidencia de Tiempos:

Se espera que los tiempos de ejecución sigan las estimaciones teóricas: lineal para la búsqueda secuencial y logarítmica para la búsqueda binaria.

se podria generar un grafico pero en phyton (preguntar a que se refiere al profe)
 */

