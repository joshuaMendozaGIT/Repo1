// view/Vista.java
package view;

import java.util.Scanner;

public class Vista {
    private Scanner scanner;
    
    public Vista() {
        scanner = new Scanner(System.in);
    }
    
    public int mostrarMenu() {
        System.out.println("\n=== GESTOR DE FIGURAS ===");
        System.out.println("1. Crear círculo");
        System.out.println("2. Crear rectángulo");
        System.out.println("3. Mostrar áreas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
    
    public double pedirRadio() {
        System.out.print("Ingrese el radio del círculo: ");
        return scanner.nextDouble();
    }
    
    public double pedirBase() {
        System.out.print("Ingrese la base del rectángulo: ");
        return scanner.nextDouble();
    }
    
    public double pedirAltura() {
        System.out.print("Ingrese la altura del rectángulo: ");
        return scanner.nextDouble();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    // MÉTODO NUEVO PARA MOSTRAR ÁREAS
    public void mostrarArea(String tipoFigura, Number area) {
        System.out.println(tipoFigura + " - Área: " + String.format("%.2f", area.doubleValue()));
    }
}