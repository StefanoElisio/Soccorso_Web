package org.univaq.swa.soccorsowebrest.business;

import java.util.List;

import org.univaq.swa.soccorsowebrest.DatabaseException;
import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.model.Mission;
import org.univaq.swa.soccorsowebrest.model.Mission.StartingMission;
import org.univaq.swa.soccorsowebrest.model.Mission.UpdateMission;
import org.univaq.swa.soccorsowebrest.model.Operator;

/**
 *
 * @author Stefano Elisio
 */
public interface MissionsService {

    String addMission(StartingMission body);

    void deleteMission(String uid) throws NotFoundException, DatabaseException;

    List<Mission> getOperatorMissions(Operator operator);

    void updateMission(String uid, UpdateMission body) throws NotFoundException, DatabaseException;
}
