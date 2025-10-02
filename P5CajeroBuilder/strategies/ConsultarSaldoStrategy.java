package strategies;

import models.cajeroModel;
import views.CajeroView;

public class ConsultarSaldoStrategy implements OperacionStrategy {
    @Override
    public void ejecutar(cajeroModel model, CajeroView view) {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }
}