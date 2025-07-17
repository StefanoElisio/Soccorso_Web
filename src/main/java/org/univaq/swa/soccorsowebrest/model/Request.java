package org.univaq.swa.soccorsowebrest.model;

import java.time.ZonedDateTime;

/**
 * Request
 */
public class Request {
    public enum Status{waiting, active, inProgress, closed}
    private String uid = null;
    private String name = null;
    private String email = null;
    private String location = null;
    private String description = null;
    private ZonedDateTime time = null;
    private float[] position = new float[2];
    private byte[] photo = null;
    private Status status = null;
    private String admin_uid = null;
    private Integer success_lvl = null;

    /**
     * @return the success_lvl
     */
    public Integer getSuccess_lvl() {
        return success_lvl;
    }

    /**
     * @param success_lvl the success_lvl to set
     */
    public void setSuccess_lvl(Integer success_lvl) {
        this.success_lvl = success_lvl;
    }

    /**
     * @return the admin_uid
     */
    public String getAdmin_uid() {
        return admin_uid;
    }

    /**
     * @param admin_uid the admin_uid to set
     */
    public void setAdmin_uid(String admin_uid) {
        this.admin_uid = admin_uid;
    }

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
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the time
     */
    public ZonedDateTime getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    /**
     * @return the position
     */
    public float[] getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(float[] position) {
        this.position = position;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /**
     * @return the status
     */

    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
