// controller/GestorFiguras.java
package controller;

import model.Figura;
import model.Circulo;
import model.Rectangulo;
import view.Vista;
import java.util.ArrayList;
import java.util.List;

public class GestorFiguras {
    private List<Figura<? extends Number>> figuras;
    private Vista vista;
    
    public GestorFiguras() {
        figuras = new ArrayList<>();
        vista = new Vista();
    }
    
    public void iniciarAplicacion() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            
            switch (opcion) {
                case 1:
                    crearCirculo();
                    break;
                    
                case 2:
                    crearRectangulo();
                    break;
                    
                case 3:
                    mostrarAreas();
                    break;
                    
                case 4:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                    
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
    
    private void crearCirculo() {
        double radio = vista.pedirRadio();
        Circulo circulo = new Circulo(radio);
        agregarFigura(circulo);
        vista.mostrarMensaje("Círculo creado exitosamente!");
    }
    
    private void crearRectangulo() {
        double base = vista.pedirBase();
        double altura = vista.pedirAltura();
        Rectangulo rectangulo = new Rectangulo(base, altura);
        agregarFigura(rectangulo);
        vista.mostrarMensaje("Rectángulo creado exitosamente!");
    }
    
    // Método genérico con restricción (extends)
    private <T extends Figura<? extends Number>> void agregarFigura(T figura) {
        figuras.add(figura);
    }
    
    private void mostrarAreas() {
        if (figuras.isEmpty()) {
            vista.mostrarMensaje("No hay figuras para mostrar.");
            return;
        }
        
        vista.mostrarMensaje("\n=== ÁREAS DE FIGURAS ===");
        for (Figura<? extends Number> figura : figuras) {
            Number area = figura.calcularArea();
            // CORRECCIÓN: Usar el nuevo método mostrarArea
            vista.mostrarArea(figura.getTipo(), area);
        }
    }
}