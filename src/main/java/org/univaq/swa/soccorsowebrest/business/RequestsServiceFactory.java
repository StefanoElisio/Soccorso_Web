package org.univaq.swa.soccorsowebrest.business;

public class RequestsServiceFactory {

    private final static RequestsServiceImpl service = new RequestsServiceImpl();

    public static RequestsServiceImpl getRequestsService() {
        return service;
    }

}
