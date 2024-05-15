/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller3;

import java.util.*;

/**
 *
 * @author PC
 */
public class LoteriaVectores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugarOtraVez;
        double totalApostado = 0;
        double totalGanado = 0;

        do {
            System.out.print("Ingrese el monto a apostar: ");
            double montoApostado = scanner.nextDouble();
            totalApostado += montoApostado;

            int[] numerosUsuario = new int[10];
            System.out.println("Ingrese 10 numeros de dos digitos:");
            for (int i = 0; i < 10; i++) {
                int numero;
                do {
                    System.out.print("Número " + (i + 1) + ": ");
                    numero = scanner.nextInt();
                } while (numero < 10 || numero > 99);
                numerosUsuario[i] = numero;
            }

            int[] numerosLoteria = generarNumerosAleatorios();
            System.out.println("Numeros ganadores: " + Arrays.toString(numerosLoteria));

            int aciertos = contarAciertos(numerosUsuario, numerosLoteria);
            double montoGanado = calcularGanancia(aciertos, montoApostado);
            totalGanado += montoGanado;

            double impuesto = montoGanado * 0.10;
            double montoACobrar = montoGanado - impuesto;

            System.out.println("Aciertos: " + aciertos);
            System.out.println("Monto ganado: $" + montoGanado);
            System.out.println("Impuesto (10%): $" + impuesto);
            System.out.println("Monto a cobrar: $" + montoACobrar);

            System.out.print("¿Desea jugar otra vez? (s/n): ");
            jugarOtraVez = scanner.next().equalsIgnoreCase("s");

        } while (jugarOtraVez);

        System.out.println("Total apostado: $" + totalApostado);
        System.out.println("Total ganado: $" + totalGanado);
        System.out.println("Ganancia/Perdida neta: $" + (totalGanado - totalApostado));

        scanner.close();
    }

    private static int[] generarNumerosAleatorios() {
        Random random = new Random();
        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = random.nextInt(90) + 10;
        }
        return numeros;
    }

    private static int contarAciertos(int[] numerosUsuario, int[] numerosLoteria) {
        Set<Integer> setLoteria = new HashSet<>();
        for (int numero : numerosLoteria) {
            setLoteria.add(numero);
        }
        int aciertos = 0;
        for (int numero : numerosUsuario) {
            if (setLoteria.contains(numero)) {
                aciertos++;
            }
        }
        return aciertos;
    }

    private static double calcularGanancia(int aciertos, double montoApostado) {
        double ganancia = 0;
        switch (aciertos) {
            case 10:
                ganancia = montoApostado * 50;
                break;
            case 5:
                ganancia = montoApostado * 25;
                break;
            case 4:
                ganancia = montoApostado * 15;
                break;
            default:
                ganancia = 0;
        }
        return ganancia;
    }
}
