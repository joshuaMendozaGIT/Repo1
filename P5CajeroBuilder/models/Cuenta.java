package models;

public class Cuenta {
    private String noCuenta;
    private String PIN;
    private double saldo;
    private String titular;
    
    // Constructor privado que solo el Builder puede usar
    private Cuenta(Builder builder) {
        this.noCuenta = builder.noCuenta;
        this.PIN = builder.PIN;
        this.titular = builder.titular;
        this.saldo = builder.saldo;
    }

    // Getters (se mantienen igual)
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
    
    // Métodos de negocio (se mantienen igual)
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
    
    // CLASE BUILDER - Aquí está la implementación del patrón
    public static class Builder {
        private String noCuenta;
        private String PIN;
        private String titular;
        private double saldo;
        
        public Builder setNoCuenta(String noCuenta) {
            this.noCuenta = noCuenta;
            return this;
        }
        
        public Builder setPIN(String PIN) {
            this.PIN = PIN;
            return this;
        }
        
        public Builder setTitular(String titular) {
            this.titular = titular;
            return this;
        }
        
        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }
        
        public Cuenta build() {
            // Validaciones antes de crear la cuenta
            if (noCuenta == null || noCuenta.trim().isEmpty()) {
                throw new IllegalArgumentException("Número de cuenta es requerido");
            }
            if (PIN == null || PIN.trim().isEmpty()) {
                throw new IllegalArgumentException("PIN es requerido");
            }
            if (titular == null || titular.trim().isEmpty()) {
                throw new IllegalArgumentException("Titular es requerido");
            }
            if (saldo < 0) {
                throw new IllegalArgumentException("El saldo no puede ser negativo");
            }
            
            return new Cuenta(this);
        }
    }
}