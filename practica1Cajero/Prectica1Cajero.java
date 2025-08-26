/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prectica1cajero;
/*
    Joshua Mendoza Teniente
    26-08-2025
Objetivo: Crear un sistema de cajero automatico sencillo que verifique la contra-
    seña de un usuario con un maximo de 3 intentos si es incorrect termina el 
    programa, si es correcta se abre la seccion de retirar, abonar, etc
*/
public class Prectica1Cajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //System.out.println("Bueneas tardes bienvenido");
        sistema a = new sistema();
        a.Seguridad();
        a.cajero();

        
    }
    
}
