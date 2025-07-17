package org.univaq.swa.soccorsowebrest.business;

import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.univaq.swa.soccorsowebrest.model.Operator;

public class OperatorsServiceImpl implements OperatorsService {

    @Override
    public String addOperator(Operator body) {
        return createUID();
    }

    @Override
    public List<Operator> getFreeOperators() {
        return createDummyOperatorsList();
    }

    @Override
    public Operator getOperator(String uid) {
        return createDummyOperator(createUID(), false);
    }

    @Override
    public List<String> getMissions(String uid) {
        return createDummyUIDList();
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

    private List<String> createDummyUIDList() {
        List<String> result = new ArrayList<>();
        int n = random.nextInt(1, 10);
        for (int i = 0; i < n; ++i) {
            result.add(createUID());
        }
        return result;
    }

    public List<Operator> createDummyOperatorsList() {
        List<Operator> result = new ArrayList<>();
        int n = random.nextInt(1, 10);
        for (int i = 0; i < n; ++i) {
            result.add(createDummyOperator(createUID(), random.nextBoolean()));
        }
        return result;
    }

    private Operator createDummyOperator(String uid, boolean free) {
        Operator e = new Operator();
        e.setUid(uid);
        e.setUsername("Operator " + e.getUid());
        e.setName("Pinco");
        e.setSurname("Pallino");
        e.setBirthdate(ZonedDateTime.now().minusYears(random.nextInt(20, 50)));
        e.setAvailability(free);
        int np = random.nextInt(0, 3);
        String p = new String();
        for (int i = 0; i < np; ++i) {
            p = createString(2);
            e.getPatents().add(p);
        }
        np = random.nextInt(0, 5);
        for (int i = 0; i < np; ++i) {
            p = createString(8);
            e.getSkills().add(p);
        }
        return e;
    }

    private String createString(int l) {
        byte[] array = new byte[l]; // length is bounded by l
        random.nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
