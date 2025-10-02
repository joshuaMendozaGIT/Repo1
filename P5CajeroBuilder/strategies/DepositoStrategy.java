package strategies;

import models.cajeroModel;
import views.CajeroView;

public class DepositoStrategy implements OperacionStrategy {
    @Override
    public void ejecutar(cajeroModel model, CajeroView view) {
        double cantidad = view.solicitarCantidad("Depositar");
        if (cantidad <= 0){
            view.mostraMensaje("Error: La cantidad debe ser mayor a cero");
            return;
        }
        if(model.realizarDeposito(cantidad)){
            view.mostraMensaje("Depósito exitoso: $" + cantidad);
            // Mostrar saldo actualizado
            double saldo = model.consultarSaldo();
            view.mostrarSaldo(saldo);
        }
        else{
            view.mostraMensaje("Error en el depósito");
        }
    }
}
