package org.univaq.swa.soccorsowebrest.business;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.univaq.swa.soccorsowebrest.model.Mission;

/**
 *
 * @author Giuseppe Della Penna
 */
public class RequestServiceImpl implements MissionsService {

    @Override
    public String addMission(Mission body) {
        //dummy
        return "IDabcdef";
    }

    @Override
    public void deleteMission(String uid) {
        //dummy
    }

    @Override
    public void deleteParticipant(String uid, String partid) {
        //dummy
    }

    @Override
    public List<Mission> getCurrentMissions(List<String> cat) {
        return createDummyMissionsList(true);
    }

    @Override
    public Mission getMission(String uid) {
        return createDummyMission(uid, false);
    }

    @Override
    public List<Mission> getMissions(ZonedDateTime from, ZonedDateTime to, List<String> cat) {
        return createDummyMissionsList(false);
    }

    @Override
    public int getNumberOfMissions(ZonedDateTime from, ZonedDateTime to, List<String> cat) {
        return 10;
    }

    @Override
    public void updateMission(String uid, Mission body) {
        //dummy
    }

    @Override
    public String addParticipant(String uid, Participant body) {
        return body.getEmail();
    }

    @Override
    public void updateRecurrence(String uid, Recurrence body) {
        //dummy
    }

    @Override
    public void updateAttachment(String uid, InputStream data) {
        //dummy
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

    private List<Mission> createDummyMissionsList(boolean current) {
        List<Mission> result = new ArrayList<>();
        int n = random.nextInt(1, 10);
        for (int i = 0; i < n; ++i) {
            result.add(createDummyMission(createUID(), current));
        }
        return result;
    }

    private Mission createDummyMission(String uid, boolean current) {
        Mission e = new Mission();
        e.setUid(uid);
        e.setSummary("Mission " + e.getUid());
        if (current) {
            e.setStart(ZonedDateTime.now().minus(random.nextInt(3), ChronoUnit.HOURS));
        } else {
            e.setStart(ZonedDateTime.now().plus(random.nextInt(30), ChronoUnit.DAYS));
        }
        e.setEnd(e.getStart().plus(random.nextInt(5), ChronoUnit.HOURS));
        int np = random.nextInt(0, 3);
        for (int i = 0; i < np; ++i) {
            Participant p = new Participant();
            p.setName("Pinco Pallino #" + i);
            p.setEmail("pinco.pallino" + i + "@univaq.it");
            e.getParticipants().add(p);
        }
        if (random.nextBoolean()) {
            Recurrence r = new Recurrence();
            r.setFrequency(Recurrence.FrequencyEnum.WEEKLY);
            r.setInterval(2);
            r.setUntil(e.getEnd().plus(2, ChronoUnit.MONTHS));
            e.setRecurrence(r);
        }
        e.setAttachment("ciao a tutti".getBytes());
        e.getCategories().add(uid);
        return e;
    }

}
