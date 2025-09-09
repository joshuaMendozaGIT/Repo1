// model/Circulo.java
package model;

public class Circulo implements Figura<Double> {
    private double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    @Override
    public Double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public String getTipo() {
        return "Círculo";
    }
}