package views;

import java.util.Scanner;

public class CajeroView {
    private Scanner scanner;
    
    public CajeroView(){
        scanner = new Scanner(System.in);
    }
    
    public void mostrarBienvenida(){
        System.out.println("*************************************************");
        System.out.println("Bienvenido al cajero automatico del banco");
        System.out.println("*************************************************");
    }
    
    public String solicitarNumeroCuenta(){
        System.out.println("Ingresa el numero de tu cuenta: ");
        return scanner.nextLine();
    }
    
    public String solicitarPIN(){
        System.out.println("Ingresa tu PIN: ");
        return scanner.nextLine();
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
        System.out.println("Selecciona una opción: ");
    }
    
    public int leerOpcion(){
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            return -1;
        }
    }
    
    //OPCIONES
    public void mostrarSaldo(double saldo){
        System.out.println("*************************************************");
        System.out.println("Su Saldo es de: $" + saldo);
        System.out.println("*************************************************");
    }
    
    public double solicitarCantidad(String operacion){
        System.out.println("Ingresa la cantidad a " + operacion + ": ");
        try{
            return Double.parseDouble(scanner.nextLine());
        }catch(NumberFormatException e){
            return -1;
        }
    }
    
    public void mostraMensaje(String mensaje){
        System.out.println("##### " + mensaje + " #####");
    }
    
    // Nuevos métodos implementados
    public String solicitarCuentaDestino(){
        System.out.println("Ingresa el número de cuenta destino: ");
        return scanner.nextLine();
    }
    
    public String solicitarPINActual(){
        System.out.println("Ingresa tu PIN actual: ");
        return scanner.nextLine();
    }
    
    public String solicitarNuevoPIN(){
        System.out.println("Ingresa tu nuevo PIN: ");
        return scanner.nextLine();
    }
    
    public String solicitarConfirmacionNIP(){
        System.out.println("Confirma tu nuevo PIN: ");
        return scanner.nextLine();
    }
    
    // Método para cerrar el scanner
    public void cerrarScanner() {
        scanner.close();
    }
}
