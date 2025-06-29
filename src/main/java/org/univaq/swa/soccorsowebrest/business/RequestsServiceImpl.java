package org.univaq.swa.soccorsowebrest.business;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.univaq.swa.soccorsowebrest.DatabaseException;
import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.model.Request;
import org.univaq.swa.soccorsowebrest.model.Request.Status;

public class RequestsServiceImpl implements RequestsService {

    @Override
    public String addRequest(Request body) {
        return createUID();
    }

    @Override
    public void deleteRequest(String uid) throws NotFoundException, DatabaseException {
    }

    @Override
    public Request getRequest(String uid) throws NotFoundException {
        return createDummyRequest(createUID(), Status.Waiting);
    }

    @Override
    public List<Request> getRequestsbyStatus(Status status) throws NotFoundException{
        return createDummyRequestsList();
    }

    @Override
    public List<Request> getClosedRequests() throws NotFoundException{
        List<Request> list = new ArrayList<Request>();
        for (Request request : createDummyRequestsList()) {
            if(request.getStatus()==Status.Closed && request.getSuccess_lvl()<5)
                list.add(request);
        }
        return list;
    }

    @Override
    public void validatingRequest(String uid) throws NotFoundException, DatabaseException {
        
    }

    @Override
    public void inProgressRequest(String uid) throws NotFoundException, DatabaseException {
    }

    @Override
    public void closingRequest(String uid) throws NotFoundException, DatabaseException {
    }

    @Override
    public void updatePhoto(String uid, InputStream data) throws NotFoundException, DatabaseException {
    }

    Random random = new Random();

    private String createUID() {
        int leftLimit = 48; // '0'
        int rightLimit = 122; // 'z'
        int targetStringLength = 10;

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return "ID" + generatedString;
    }

    private List<Request> createDummyRequestsList() {
        List<Request> result = new ArrayList<>();
        int n = random.nextInt(1, 10);
        Status[] statuses = Status.values();
        for (int i = 0; i < n; ++i) {
            result.add(createDummyRequest(createUID(), statuses[random.nextInt(statuses.length)] ));
        }
        return result;
    }

    private Request createDummyRequest(String uid, Status status) {
        Request e = new Request();
        e.setUid(uid);
        e.setName("Pinco." + uid);
        e.setEmail(e.getName()+"@pallinomail.com");
        e.setDescription(uid + " richiesta di aiuto");
        e.setLocation("Regione della pizza");
        e.setTime(ZonedDateTime.now().minus(random.nextInt(24), ChronoUnit.HOURS));
        e.setPosition(new float[]{random.nextFloat(-90,90),random.nextFloat(-180,180)});
        e.setPhoto("Una bella foto :D".getBytes());
        e.setStatus(status);
        e.setAdmin_uid(createUID());
        e.setSuccess_lvl(random.nextInt(6));
        return e;
    }

}
