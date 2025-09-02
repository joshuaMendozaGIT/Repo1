package controllers;

import models.cajeroModel;
import views.CajeroView;

public class CajeroController {
    private cajeroModel model;
    private CajeroView view;
    
    private boolean sistemaActivo;

    public CajeroController(cajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }
    
    public void iniciarCajero(){
        view.mostrarBienvenida();
        while(sistemaActivo){
            if(autentificarUsuario()){
                ejecutarMenuPrincipal();
            }else{
                view.mostraMensaje("Credenciales incorrectas");
            }
            view.mostraMensaje("Gracias vuelva pronto");
        }
    }
    
    private boolean autentificarUsuario(){
        String noCuenta = view.solicitarNumeroCuenta();
        String PIN = view.solicitarPIN();
        return model.auntentificar(noCuenta, PIN);
    }
    
    private void ejecutarMenuPrincipal(){
        boolean sesionActiva = true;
        while(sesionActiva){
            view.mostrarMenu(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();
            switch(opcion){
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    realizarRetiro();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarTransferencia();
                    break;
                case 5:
                    cambiarPIN();
                    break;
                case 6:
                    sesionActiva = false;
                    view.mostraMensaje("Sesión finalizada");
                    break;
                default:
                    view.mostraMensaje("Opción no válida");
                    break;
            }
        }
    }
    
    public void consultarSaldo(){
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }
    
    public void realizarRetiro(){
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad <= 0){
            view.mostraMensaje("Error: La cantidad debe ser mayor a cero");
            return;
        }
        if(model.realizarRetiro(cantidad)){
            view.mostraMensaje("Retiro realizado exitosamente: $" + cantidad);
            consultarSaldo();
        }
        else{
            view.mostraMensaje("Fondos insuficientes");
        }
    }
    
    public void realizarDeposito(){
        double cantidad = view.solicitarCantidad("Depositar");
        if (cantidad <= 0){
            view.mostraMensaje("Error: La cantidad debe ser mayor a cero");
            return;
        }
        if(model.realizarDeposito(cantidad)){
            view.mostraMensaje("Depósito exitoso: $" + cantidad);
            consultarSaldo();
        }
        else{
            view.mostraMensaje("Error en el depósito");
        }
    }
    
    // Nuevos métodos implementados
    public void realizarTransferencia(){
        String cuentaDestino = view.solicitarCuentaDestino();
        double cantidad = view.solicitarCantidad("Transferir");
        
        if (cantidad <= 0){
            view.mostraMensaje("Error: La cantidad debe ser mayor a cero");
            return;
        }
        
        if(!model.cuentaExixtente(cuentaDestino)){
            view.mostraMensaje("Error: La cuenta destino no existe");
            return;
        }
        
        if(model.realizarTransferencia(cuentaDestino, cantidad)){
            view.mostraMensaje("Transferencia realizada exitosamente: $" + cantidad);
            consultarSaldo();
        }
        else{
            view.mostraMensaje("Error: No se pudo completar la transferencia. Fondos insuficientes.");
        }
    }
    
    public void cambiarPIN(){
        String nipActual = view.solicitarPINActual();
        String nuevoNIP = view.solicitarNuevoPIN();
        String confirmacionNIP = view.solicitarConfirmacionNIP();
        
        if(!nuevoNIP.equals(confirmacionNIP)){
            view.mostraMensaje("Error: Los PINs nuevos no coinciden");
            return;
        }
        
        if(model.cambiarNIP(nipActual, nuevoNIP)){
            view.mostraMensaje("PIN cambiado exitosamente");
        }
        else{
            view.mostraMensaje("Error: PIN actual incorrecto");
        }
    }
}