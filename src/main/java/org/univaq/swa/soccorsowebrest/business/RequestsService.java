package org.univaq.swa.soccorsowebrest.business;

import java.io.InputStream;
import java.util.List;

import org.univaq.swa.soccorsowebrest.DatabaseException;
import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.model.Request;
import org.univaq.swa.soccorsowebrest.model.Request.Status;

public interface RequestsService {

    String addRequest(Request body);

    void deleteRequest(String uid) throws NotFoundException, DatabaseException;

    Request getRequest(String uid) throws NotFoundException;

    List<Request> getRequests(Status status) throws NotFoundException;

    List<Request> getClosedRequests() throws NotFoundException;

    void validatingRequest(String uid) throws NotFoundException, DatabaseException;

    void inProgressRequest(String uid) throws NotFoundException, DatabaseException;

    void closingRequest(String uid) throws NotFoundException, DatabaseException;

    void updatePhoto(String uid, InputStream data) throws NotFoundException, DatabaseException;

}
