package org.univaq.swa.soccorsowebrest.business;

import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.univaq.swa.soccorsowebrest.model.Mission;
import org.univaq.swa.soccorsowebrest.model.Mission.StartingMission;
import org.univaq.swa.soccorsowebrest.model.Mission.UpdateMission;
import org.univaq.swa.soccorsowebrest.model.Operator;

public class MissionsServiceImpl implements MissionsService {

    @Override
    public String addMission(StartingMission body) {
        return createUID();
    }

    @Override
    public void deleteMission(String uid) {
    }

    @Override
    public Mission getMission(String uid) {
        return createDummyMission(uid);
    }

    @Override
    public List<Mission> getMissions(ZonedDateTime from, ZonedDateTime to) {
        List<Mission> list = new ArrayList<Mission>();
        for (Mission mission : createDummyMissionsList()) {
            if (mission.getEnd().compareTo(from) >= 0 && mission.getEnd().compareTo(to) <= 0)
                list.add(mission);
        }
        return list;
    }

    @Override
    public List<Mission> getOperatorMissions(String uid) {
        List<Mission> list = new ArrayList<Mission>();
        for (Mission mission : createDummyMissionsList()) {
            for (Operator operator : mission.getOperators()) {
                if (operator.getUid() == uid) {
                    list.add(mission);
                    break;
                }
            }
        }
        return list;
    }

    @Override
    public void updateMission(String uid, UpdateMission body) {
    }

    ///////
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

    private List<Mission> createDummyMissionsList() {
        List<Mission> result = new ArrayList<>();
        int n = random.nextInt(1, 10);
        for (int i = 0; i < n; ++i) {
            result.add(createDummyMission(createUID()));
        }
        return result;
    }

    private Mission createDummyMission(String uid) {
        final OperatorsServiceImpl opService = OperatorsServiceFactory.getOperatorsService();
        Mission e = new Mission();
        e.setUid(uid);
        e.setRequest_uid(createUID());
        e.setObjective("Aiutare " + uid);
        e.setOperators(new ArrayList<Operator>(opService.createDummyOperatorsList()));
        int np = random.nextInt(1, 5);
        String p = new String();
        for (int i = 0; i < np; ++i) {
            p = createString(10);
            e.getVehicles().add(p);
        }
        np = random.nextInt(2, 10);
        for (int i = 0; i < np; ++i) {
            p = createString(10);
            e.getEquipment().add(p);
        }
        e.setStart(ZonedDateTime.now().minus(random.nextInt(24,3), ChronoUnit.HOURS));
        if(random.nextBoolean()){
            e.setEnd(e.getStart().plus(random.nextInt(3), ChronoUnit.HOURS));
            e.setUpdates(createDummyUpdates(e));
            e.setComments(createDummyComments(e));
            }
        return e;
    }

    private Map<ZonedDateTime,String> createDummyUpdates(Mission mission){
        Map<ZonedDateTime,String> updates = new TreeMap<ZonedDateTime, String>();
        int totaltime = mission.getEnd().compareTo(mission.getStart());
        int np = random.nextInt(1, 5);
        ZonedDateTime time;
        String p = new String();
        for (int i = 0; i < np; ++i) {
            time = mission.getStart().plus(random.nextInt(totaltime), ChronoUnit.HOURS);
            p = createString(10);
            updates.put(time, p);
        }
        return updates;
    }

    private Map<Operator,String> createDummyComments(Mission mission){
        Map<Operator,String> comments = new HashMap<Operator, String>();
        int np = random.nextInt(1, 5);
        Operator op;
        String p = new String();
        for (int i = 0; i < np; ++i) {
            op = mission.getOperators().get(random.nextInt(mission.getOperators().size()));
            p = createString(30);
            comments.put(op, p);
        }
        return comments;
    }

    private String createString(int l) {
        byte[] array = new byte[l]; // length is bounded by l
        random.nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
