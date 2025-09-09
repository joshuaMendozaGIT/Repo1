// model/Rectangulo.java
package model;

public class Rectangulo implements Figura<Double> {
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public Double calcularArea() {
        return base * altura;
    }
    
    @Override
    public String getTipo() {
        return "Rectángulo";
    }
}