package models.services;

import models.repositories.impl.CuentaRepositoryImpl;

public class CuentaService{

    private final CuentaRepositoryImpl cuentaRepository;

    public CuentaService(){
        this.cuentaRepository = new CuentaRepositoryImpl();
    }
}
