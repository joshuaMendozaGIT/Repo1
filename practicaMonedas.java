/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.moneda;
import java.util.Scanner;

/**
 *
 * @author bere1
 */


public class Moneda {

    public static void main(String[] args) {
        Scanner can = new Scanner(System.in);
        System.out.println("Introduce la cantidad: ");
        int cantidad = can.nextInt();
        
        transformarMoneda(cantidad);
    }
    
    public static void transformarMoneda(int cantidad) {
        System.out.println("Cantidad: " + cantidad);
        
        int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        
        for (int i = 0; i< denominaciones.length; i++) {
            int valor = denominaciones[i];
            
            if (cantidad >= valor) {
                int unidades = cantidad / valor;
                System.out.println(unidades + " de " + valor);
                cantidad = cantidad % valor;
            }
        }
        
        if (cantidad == 0) {
            System.out.println("Descomposición terminada");
        }
    }
}

