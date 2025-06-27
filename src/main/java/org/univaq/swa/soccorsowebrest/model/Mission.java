package org.univaq.swa.soccorsowebrest.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Mission
 */
public class Mission {
    public class StartingMission {
        private String uid = null;
        private Request request;
        private String objective = null;
        private ArrayList<Operator> operators = new ArrayList<Operator>();
        private ArrayList<String> vehicles = new ArrayList<String>();
        private ArrayList<String> equipment = new ArrayList<String>();
        private ZonedDateTime start = null;
    }

    private StartingMission starting_mission = new StartingMission();

    public class UpdateMission {
        private ZonedDateTime end = null;
        private Map<ZonedDateTime, String> updates = new TreeMap<ZonedDateTime, String>();
        private Map<Operator, String> comments = new HashMap<Operator, String>();
    }

    private UpdateMission updateMission = new UpdateMission();

    /**
     * @return the uid
     */
    public String getUid() {
        return this.starting_mission.uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.starting_mission.uid = uid;
    }

    /**
     * @return the request
     */
    public Request getRequest() {
        return this.starting_mission.request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Request request) {
        this.starting_mission.request = request;
    }

    /**
     * @return the objective
     */
    public String getObjective() {
        return this.starting_mission.objective;
    }

    /**
     * @param objective the objective to set
     */
    public void setObjective(String objective) {
        this.starting_mission.objective = objective;
    }

    /**
     * @return the operators
     */
    public ArrayList<Operator> getOperators() {
        return this.starting_mission.operators;
    }

    /**
     * @param operators the operators to set
     */
    public void setOperators(ArrayList<Operator> operators) {
        this.starting_mission.operators = operators;
    }

    /**
     * @return the vehicles
     */
    public ArrayList<String> getVehicles() {
        return this.starting_mission.vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(ArrayList<String> vehicles) {
        this.starting_mission.vehicles = vehicles;
    }

    /**
     * @return the equipment
     */
    public ArrayList<String> getEquipment() {
        return this.starting_mission.equipment;
    }

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(ArrayList<String> equipment) {
        this.starting_mission.equipment = equipment;
    }

    /**
     * @return the start
     */
    public ZonedDateTime getStart() {
        return this.starting_mission.start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(ZonedDateTime start) {
        this.starting_mission.start = start;
    }

    /**
     * @return the startingMission
     */
    public StartingMission getStartingMission() {
        return this.starting_mission;
    }

    /**
     * @param startingMission the startingMission to set
     */
    public void setStartingMission(StartingMission startingMission) {
        this.starting_mission = startingMission;
    }

    /**
     * @return the end
     */
    public ZonedDateTime getEnd() {
        return this.updateMission.end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(ZonedDateTime end) {
        this.updateMission.end = end;
    }

    /**
     * @return the updates
     */
    public Map<ZonedDateTime, String> getUpdates() {
        return this.updateMission.updates;
    }

    /**
     * @param updates the updates to set
     */
    public void setUpdates(Map<ZonedDateTime, String> updates) {
        this.updateMission.updates = updates;
    }

    /**
     * @return the comments
     */
    public Map<Operator, String> getComments() {
        return this.updateMission.comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(Map<Operator, String> comments) {
        this.updateMission.comments = comments;
    }
}