package views;

import models.cajeroModel;
import controllers.CajeroController;

public class CajeroAutomatico {
    public static void main(String[] args){
        cajeroModel model = new cajeroModel();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model, view);
        
        try {
            controller.iniciarCajero();
        } finally {
            view.cerrarScanner();
        }
    }
}