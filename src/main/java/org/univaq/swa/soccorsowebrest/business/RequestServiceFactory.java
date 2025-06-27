package org.univaq.swa.soccorsowebrest.business;

/**
 *
 * @author Stefano Elisio
 */
public class RequestServiceFactory {

    private final static RequestServiceImpl service = new RequestServiceImpl();

    public static RequestServiceImpl getRequestService() {
        return service;
    }

}
