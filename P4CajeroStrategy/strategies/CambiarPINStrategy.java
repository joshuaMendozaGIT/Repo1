package strategies;

import models.cajeroModel;
import views.CajeroView;

public class CambiarPINStrategy implements OperacionStrategy {
    @Override
    public void ejecutar(cajeroModel model, CajeroView view) {
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