package org.univaq.swa.soccorsowebrest.business;

import java.util.List;

import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.model.Operator;

public interface OperatorsService {

    String addOperator(Operator body);

    List<Operator> getFreeOperators() throws NotFoundException;

    Operator getOperator(String uid) throws NotFoundException;

    List<Operator> createDummyOperatorsList();

    List<String> getMissions(String uid) throws NotFoundException;
}
