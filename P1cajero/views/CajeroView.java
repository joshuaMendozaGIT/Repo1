package views;

import java.util.Scanner;
import java.util.function.Function;

public class CajeroView {
    private Scanner scanner;
    
    // Lectores genéricos para diferentes tipos de datos
    private Lector<Integer> lectorEnteros;
    private Lector<Double> lectorDecimales;
    private Lector<String> lectorTextos;
    
    public CajeroView(){
        scanner = new Scanner(System.in);
        lectorEnteros = new Lector<>(Integer::parseInt, "Entrada inválida. Debe ser un número entero.");
        lectorDecimales = new Lector<>(Double::parseDouble, "Entrada inválida. Debe ser un número decimal.");
        lectorTextos = new Lector<>(s -> s, "Entrada inválida.");
    }
    
    // Clase genérica interna para manejar la lectura de datos
    public class Lector<T> {
        private Function<String, T> conversor;
        private String mensajeError;
        
        public Lector(Function<String, T> conversor, String mensajeError) {
            this.conversor = conversor;
            this.mensajeError = mensajeError;
        }
        
        public T leer(String mensaje) {
            while (true) {
                try {
                    System.out.print(mensaje);
                    String entrada = scanner.nextLine();
                    return conversor.apply(entrada);
                } catch (Exception e) {
                    System.out.println(mensajeError);
                }
            }
        }
    }
    
    public String solicitarNumeroCuenta(){
        return lectorTextos.leer("Ingresa el numero de tu cuenta: ");
    }
    
    public String solicitarPIN(){
        return lectorTextos.leer("Ingresa tu PIN: ");
    }
    
    public int leerOpcion(){
        return lectorEnteros.leer("Selecciona una opción: ");
    }
    
    public double solicitarCantidad(String operacion){
        return lectorDecimales.leer("Ingresa la cantidad a " + operacion + ": ");
    }
    
    // Resto de los métodos se mantienen igual...
    public void mostrarBienvenida(){
        System.out.println("*************************************************");
        System.out.println("Bienvenido al cajero automatico del banco");
        System.out.println("*************************************************");
    }
    
    public void mostrarMenu(String titular){
        System.out.println("*************************************************");
        System.out.println("Bienvenido " + titular);
        System.out.println("*************************************************");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Retirar");
        System.out.println("3. Depositar");
        System.out.println("4. Transferir");
        System.out.println("5. Cambiar PIN");
        System.out.println("6. Salir");
    }
    
    public void mostrarSaldo(double saldo){
        System.out.println("*************************************************");
        System.out.println("Su Saldo es de: $" + saldo);
        System.out.println("*************************************************");
    }
    
    public void mostraMensaje(String mensaje){
        System.out.println("##### " + mensaje + " #####");
    }
    
    public String solicitarCuentaDestino(){
        return lectorTextos.leer("Ingresa el número de cuenta destino: ");
    }
    
    public String solicitarPINActual(){
        return lectorTextos.leer("Ingresa tu PIN actual: ");
    }
    
    public String solicitarNuevoPIN(){
        return lectorTextos.leer("Ingresa tu nuevo PIN: ");
    }
    
    public String solicitarConfirmacionNIP(){
        return lectorTextos.leer("Confirma tu nuevo PIN: ");
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}