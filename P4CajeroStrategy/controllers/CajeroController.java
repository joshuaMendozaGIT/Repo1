package controllers;

import models.cajeroModel;
import views.CajeroView;
import strategies.*;

import java.util.HashMap;
import java.util.Map;

public class CajeroController {
    private cajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;
    private Map<Integer, OperacionStrategy> estrategias;
    
    public CajeroController(cajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
        this.estrategias = new HashMap<>();
        inicializarEstrategias();
    }
    
    private void inicializarEstrategias() {
        estrategias.put(1, new ConsultarSaldoStrategy());
        estrategias.put(2, new RetiroStrategy());
        estrategias.put(3, new DepositoStrategy());
        estrategias.put(4, new TransferenciaStrategy());
        estrategias.put(5, new CambiarPINStrategy());
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
            
            if (opcion == 6) {
                sesionActiva = false;
                view.mostraMensaje("Sesión finalizada");
            } else {
                OperacionStrategy estrategia = estrategias.get(opcion);
                if (estrategia != null) {
                    estrategia.ejecutar(model, view);
                } else {
                    view.mostraMensaje("Opción no válida");
                }
            }
        }
    }
}