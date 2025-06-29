package org.univaq.swa.soccorsowebrest.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

import org.univaq.swa.soccorsowebrest.model.Mission;

public class MissionSerializer extends JsonSerializer<Mission> {

    @Override
    public void serialize(Mission mission, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();

        jgen.writeStringField("uid", mission.getUid());
        jgen.writeStringField("request_uid", mission.getRequest_uid());
        jgen.writeStringField("objective", mission.getObjective());
        jgen.writeObjectField("operators", mission.getOperators());
        jgen.writeObjectField("vehicles", mission.getVehicles());
        jgen.writeObjectField("equipment", mission.getEquipment());
        jgen.writeObjectField("start", mission.getStart());
        jgen.writeObjectField("end", mission.getEnd());
        jgen.writeObjectField("updates", mission.getUpdates());
        jgen.writeObjectField("comments", mission.getComments());        

        jgen.writeEndObject();
    }
}