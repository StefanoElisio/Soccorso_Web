package org.univaq.swa.soccorsowebrest.business;

import java.util.List;

import org.univaq.swa.soccorsowebrest.DatabaseException;
import org.univaq.swa.soccorsowebrest.NotFoundException;
import org.univaq.swa.soccorsowebrest.model.Operator;

/**
 *
 * @author Stefano Elisio
 */
public interface OperatorsService {

    String addOperator(Operator body);

    List<Operator> getFreeOperators() throws NotFoundException;

    Operator getOperator(String uid) throws NotFoundException;
}
