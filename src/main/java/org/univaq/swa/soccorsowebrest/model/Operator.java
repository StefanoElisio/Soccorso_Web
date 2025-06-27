package org.univaq.swa.soccorsowebrest.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Operator
 */
public class Operator {
    public class Registry{
        private String name = null;
        private String surname = null;
        private ZonedDateTime birthdate = null;
    }
    private String uid = null;
    private String username = null;
    private ArrayList<String> patents = new ArrayList<String>();
    private ArrayList<String> skills = new ArrayList<String>();
    private Boolean availability = false;
    private Registry registry = new Registry();


    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return registry.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.registry.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return registry.surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.registry.surname = surname;
    }

    /**
     * @return the birthdate
     */
    public ZonedDateTime getBirthdate() {
        return registry.birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(ZonedDateTime birthdate) {
        this.registry.birthdate = birthdate;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the availability
     */
    public Boolean getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    /**
     * @return the patents
     */
    public ArrayList<String> getPatents() {
        return patents;
    }

    /**
     * @param patents the patents to set
     */
    public void setPatents(ArrayList<String> patents) {
        this.patents = patents;
    }

    /**
     * @return the skills
     */
    public ArrayList<String> getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    /**
     * @return the registry
     */
    public Registry getRegistry() {
        return registry;
    }

    /**
     * @param registry the registry to set
     */
    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
