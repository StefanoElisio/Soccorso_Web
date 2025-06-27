package org.univaq.swa.soccorsowebrest;

/**
 *
 * @author Giuseppe Della Penna
 */
public class DatabaseException extends Exception {

    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }
    
}
