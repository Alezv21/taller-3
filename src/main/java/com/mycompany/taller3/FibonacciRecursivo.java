/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class FibonacciRecursivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        int n = scanner.nextInt();
        scanner.close();

        List<Integer> fibonacciList = fibonacciRecursivo(n);
        System.out.println("Los primeros " + n + " numeros de Fibonacci (recursivo) son: " + fibonacciList);
    }

    public static List<Integer> fibonacciRecursivo(int n) {
        List<Integer> fibonacciList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fibonacciList.add(fibonacci(i));
        }
        return fibonacciList;
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
