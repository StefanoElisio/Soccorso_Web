package org.univaq.swa.soccorsowebrest.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.ZonedDateTime;

import org.univaq.swa.soccorsowebrest.model.Request;

// Da aggiungere eccezioni
public class RequestDeserializer extends JsonDeserializer<Request> {

    @Override
    public Request deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);
        Request request = new Request();

        if (node.has("uid"))
            request.setUid(node.get("uid").asText());
        if (node.has("name"))
            request.setName(node.get("name").asText());
        if (node.has("email"))
            request.setEmail(node.get("email").asText());
        if (node.has("location"))
            request.setLocation(node.get("location").asText());
        if (node.has("description"))
            request.setDescription(node.get("description").asText());
        if (node.has("admin_uid"))
            request.setAdmin_uid(node.get("admin_uid").asText());
        if (node.has("success_lvl"))
            request.setSuccess_lvl(node.get("success_lvl").asInt());
        if (node.has("time"))
            request.setTime(p.getCodec().treeToValue(node.get("time"), ZonedDateTime.class));

        if (node.has("position")) {
            JsonNode positionNode = node.get("position");
            float[] position = new float[2];
            position[0] = (float) positionNode.get(0).asDouble();
            position[1] = (float) positionNode.get(1).asDouble();
            request.setPosition(position);
        }

        if (node.has("photo"))
            request.setPhoto(node.get("photo").binaryValue());
        if (node.has("status"))
            request.setStatus(Request.Status.valueOf(node.get("status").asText()));

        return request;
    }
}