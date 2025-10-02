package strategies;

import models.cajeroModel;
import views.CajeroView;

public class TransferenciaStrategy implements OperacionStrategy {
    @Override
    public void ejecutar(cajeroModel model, CajeroView view) {
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
            // Mostrar saldo actualizado
            double saldo = model.consultarSaldo();
            view.mostrarSaldo(saldo);
        }
        else{
            view.mostraMensaje("Error: No se pudo completar la transferencia. Fondos insuficientes.");
        }
    }
}
