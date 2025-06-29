package org.univaq.swa.soccorsowebrest.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.ZonedDateTime;

import org.univaq.swa.soccorsowebrest.model.Mission;

public class MissionDeserializer extends JsonDeserializer<Mission> {

    @Override
    public Mission deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);
        Mission mission = new Mission();

        if (node.has("uid"))
            mission.setUid(node.get("uid").asText());
        if (node.has("request_uid"))
            mission.setRequest_uid(node.get("request_uid").asText());
        if (node.has("objective"))
            mission.setObjective(node.get("objective").asText());
        if (node.has("start"))
            mission.setStart(p.getCodec().treeToValue(node.get("start"), ZonedDateTime.class));
        if (node.has("end"))
            mission.setEnd(p.getCodec().treeToValue(node.get("end"), ZonedDateTime.class));

        return mission;
    }
}