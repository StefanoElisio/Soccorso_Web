package org.univaq.swa.soccorsowebrest.business;

/**
 *
 * @author Stefano Elisio
 */
public class MissionsServiceFactory {

    private final static MissionsServiceImpl service = new MissionsServiceImpl();

    public static MissionsServiceImpl getMissionsService() {
        return service;
    }

}
