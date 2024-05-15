/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.taller3;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class FibonacciIterativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        int n = scanner.nextInt();
        scanner.close();
        
        List<Integer> fibonacciList = fibonacciIterativo(n);
        System.out.println("Los primeros " + n + " numeros de Fibonacci (iterativo) son: " + fibonacciList);
    }

    public static List<Integer> fibonacciIterativo(int n) {
        List<Integer> fibonacciList = new ArrayList<>();
        if (n <= 0) {
            return fibonacciList;
        }

        fibonacciList.add(0);
        if (n == 1) {
            return fibonacciList;
        }

        fibonacciList.add(1);
        for (int i = 2; i < n; i++) {
            int fib = fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
            fibonacciList.add(fib);
        }

        return fibonacciList;
    }
}
