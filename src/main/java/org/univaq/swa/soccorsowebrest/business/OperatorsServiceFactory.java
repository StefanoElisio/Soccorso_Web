package org.univaq.swa.soccorsowebrest.business;

public class OperatorsServiceFactory {

    private final static OperatorsServiceImpl service = new OperatorsServiceImpl();

    public static OperatorsServiceImpl getOperatorsService() {
        return service;
    }

}
