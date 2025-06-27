package org.univaq.swa.soccorsowebrest.business;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.List;

import org.univaq.swa.soccorsowebrest.DatabaseException;
import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.model.Mission;
import org.univaq.swa.soccorsowebrest.model.Operator;

/**
 *
 * @author Stefano Elisio
 */
public interface RequestService {

    String addMission(Mission body);

    void deleteMission(String uid) throws NotFoundException, DatabaseException;

    List<Mission> getOperatorMissions(Operator operator);

    Mission getMission(String uid) throws NotFoundException;

    List<Mission> getMissions(ZonedDateTime from, ZonedDateTime to, List<String> cat);

    int getNumberOfMissions(ZonedDateTime from, ZonedDateTime to, List<String> cat);

    void updateMission(String uid, Mission body) throws NotFoundException, DatabaseException;

    void updateRecurrence(String uid, Recurrence body) throws NotFoundException, DatabaseException;

    String addParticipant(String uid, Participant body) throws NotFoundException;

    void deleteParticipant(String uid, String partid) throws NotFoundException, DatabaseException;

    void updateAttachment(String uid, InputStream data) throws NotFoundException, DatabaseException;

}
