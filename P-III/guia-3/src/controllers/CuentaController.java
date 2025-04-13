package controllers;

import models.services.CuentaService;

public class CuentaController{

    private final CuentaService cuentaService;

    public CuentaController(){
        this.cuentaService = new CuentaService();
    }
}
