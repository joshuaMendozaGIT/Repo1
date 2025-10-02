package models;

import java.util.HashMap;
import java.util.Map;

public class cajeroModel {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;
    
    public cajeroModel(){
        cuentas = new HashMap<>();
        inicializarCuentas();
    }
    
    private void inicializarCuentas(){
        // USANDO EL BUILDER - mucho más legible y flexible
        cuentas.put("12345", new Cuenta.Builder()
                .setNoCuenta("12345")
                .setPIN("1111")
                .setTitular("chino")
                .setSaldo(5000)
                .build());
                
        cuentas.put("12346", new Cuenta.Builder()
                .setNoCuenta("12346")
                .setPIN("2222")
                .setTitular("pedro")
                .setSaldo(500)
                .build());
    }

    public boolean auntentificar(String noCuenta, String PIN){
        Cuenta cuenta = cuentas.get(noCuenta);
        if( cuenta != null && cuenta.validarPIN(PIN)){
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }
    
    public Cuenta getCuentaActual(){
        return this.cuentaActual;
    }
    
    public double consultarSaldo(){
        return this.cuentaActual != null ? cuentaActual.getSaldo() : 0;
    }
    
    public boolean realizarRetiro(double cantidad){
        return this.cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    
    public boolean realizarDeposito(double cantidad){
        if(cuentaActual != null && cantidad > 0){
            cuentaActual.depocitar(cantidad);
            return true;
        }
        return false;
    }
    
    public boolean cuentaExixtente(String noCuenta){
        return cuentas.containsKey(noCuenta);
    }
    
    // Nuevos métodos implementados
    public boolean realizarTransferencia(String cuentaDestino, double cantidad){
        if(cuentaActual != null && cantidad > 0 && cuentas.containsKey(cuentaDestino)){
            Cuenta destino = cuentas.get(cuentaDestino);
            if(cuentaActual.retirar(cantidad)){
                destino.depocitar(cantidad);
                return true;
            }
        }
        return false;
    }
    
    public boolean cambiarNIP(String nipActual, String nuevoNIP){
        if(cuentaActual != null && cuentaActual.validarPIN(nipActual)){
            cuentaActual.setPIN(nuevoNIP);
            return true;
        }
        return false;
    }
}