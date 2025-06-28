package org.univaq.swa.soccorsowebrest.business;

import java.time.ZonedDateTime;
import java.util.List;

import org.univaq.swa.soccorsowebrest.DatabaseException;
import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.model.Mission;
import org.univaq.swa.soccorsowebrest.model.Mission.StartingMission;
import org.univaq.swa.soccorsowebrest.model.Mission.UpdateMission;

public interface MissionsService {

    String addMission(StartingMission body);

    void deleteMission(String uid) throws NotFoundException, DatabaseException;

    Mission getMission(String uid) throws NotFoundException;

    List<Mission> getMissions(ZonedDateTime from, ZonedDateTime to);

    List<Mission> getOperatorMissions(String op_uid);

    void updateMission(String uid, UpdateMission body) throws NotFoundException, DatabaseException;
}
