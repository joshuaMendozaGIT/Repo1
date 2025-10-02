package strategies;

import models.cajeroModel;
import views.CajeroView;

public interface OperacionStrategy {
    void ejecutar(cajeroModel model, CajeroView view);
}