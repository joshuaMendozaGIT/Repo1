package strategies;

import models.cajeroModel;
import views.CajeroView;

public class RetiroStrategy implements OperacionStrategy {
    @Override
    public void ejecutar(cajeroModel model, CajeroView view) {
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad <= 0){
            view.mostraMensaje("Error: La cantidad debe ser mayor a cero");
            return;
        }
        if(model.realizarRetiro(cantidad)){
            view.mostraMensaje("Retiro realizado exitosamente: $" + cantidad);
            // Mostrar saldo actualizado
            double saldo = model.consultarSaldo();
            view.mostrarSaldo(saldo);
        }
        else{
            view.mostraMensaje("Fondos insuficientes");
        }
    }
}