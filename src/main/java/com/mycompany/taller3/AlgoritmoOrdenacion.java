/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller3;
import java.util.Random;

/**
 *
 * @author PC
 */
public class AlgoritmoOrdenacion {

    public static void main(String[] args) {
        int[] tamanos = {10000, 100000, 1000000, 10000000};
        
        System.out.printf("%-10s %-10s %-10s %-10s\n", "N", "Insercion", "Merge Sort", "Quick Sort");

        for (int N : tamanos) {
            int[] vector = generarVectorAleatorio(N);

            long tiempoInsercion = medirTiempo(() -> insercion(vector.clone()));

            long tiempoMergeSort = medirTiempo(() -> mergeSort(vector.clone(), 0, vector.length - 1));

            long tiempoQuickSort = medirTiempo(() -> quickSort(vector.clone(), 0, vector.length - 1));

            System.out.printf("%-10d %-10d %-10d %-10d\n", N, tiempoInsercion, tiempoMergeSort, tiempoQuickSort);
        }
    }

    public static int[] generarVectorAleatorio(int tamano) {
        Random rand = new Random();
        int[] vector = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            vector[i] = rand.nextInt(tamano);
        }
        return vector;
    }

    public static void insercion(int[] vector) {
        for (int i = 1; i < vector.length; i++) {
            int actual = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > actual) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = actual;
        }
    }

    public static void mergeSort(int[] vector, int inicio, int fin) {
        if (inicio < fin) {
            int mitad = (inicio + fin) / 2;
            mergeSort(vector, inicio, mitad);
            mergeSort(vector, mitad + 1, fin);
            fusionar(vector, inicio, mitad, fin);
        }
    }

    public static void fusionar(int[] vector, int inicio, int mitad, int fin) {
        int[] auxiliar = new int[fin - inicio + 1];
        int i = inicio, j = mitad + 1, k = 0;
        while (i <= mitad && j <= fin) {
            if (vector[i] <= vector[j]) {
                auxiliar[k++] = vector[i++];
            } else {
                auxiliar[k++] = vector[j++];
            }
        }
        while (i <= mitad) {
            auxiliar[k++] = vector[i++];
        }
        while (j <= fin) {
            auxiliar[k++] = vector[j++];
        }
        for (i = 0; i < k; i++) {
            vector[inicio + i] = auxiliar[i];
        }
    }

    public static void quickSort(int[] vector, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(vector, inicio, fin);
            quickSort(vector, inicio, indiceParticion - 1);
            quickSort(vector, indiceParticion + 1, fin);
        }
    }

    public static int particion(int[] vector, int inicio, int fin) {
        int pivote = vector[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (vector[j] <= pivote) {
                i++;
                int temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
        }
        int temp = vector[i + 1];
        vector[i + 1] = vector[fin];
        vector[fin] = temp;
        return i + 1;
    }

    public static long medirTiempo(Runnable tarea) {
        long inicio = System.nanoTime();
        tarea.run();
        long fin = System.nanoTime();
        return fin - inicio;
    }
}