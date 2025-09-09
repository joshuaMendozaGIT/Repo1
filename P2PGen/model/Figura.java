// model/Figura.java
package model;

public interface Figura<T> {
    T calcularArea();
    String getTipo();
}