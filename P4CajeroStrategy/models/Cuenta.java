package models;

public class Cuenta {
    private String noCuenta;
    private String PIN;
    private double saldo;
    private String titular; 
    
    public Cuenta(String noCuenta, String PIN, String titular, double saldo){
        this.noCuenta = noCuenta;
        this.PIN = PIN;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public String getPIN() {
        return PIN;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
    
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
    
    //reglas de negocio
    public boolean validarPIN(String pinIngresado){
        return this.PIN.equals(pinIngresado);
    }
    
    public boolean retirar(double cantidad){
        if(cantidad > 0 && cantidad <= this.saldo){
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    
    public void depocitar(double cantidad){
        if(cantidad > 0){
            saldo += cantidad;
        }
    }
}
