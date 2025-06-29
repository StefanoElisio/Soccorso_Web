package org.univaq.swa.soccorsowebrest.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.ZonedDateTime;

import org.univaq.swa.soccorsowebrest.model.Operator;

public class OperatorDeserializer extends JsonDeserializer<Operator> {

    @Override
    public Operator deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);
        Operator operator = new Operator();

        if (node.has("uid"))
            operator.setUid(node.get("uid").asText());
        if (node.has("name"))
            operator.setName(node.get("name").asText());
        if (node.has("surname"))
            operator.setSurname(node.get("surname").asText());
        if (node.has("birthdate"))
            operator.setBirthdate(p.getCodec().treeToValue(node.get("birthdate"), ZonedDateTime.class));
        if (node.has("username"))
            operator.setUsername(node.get("username").asText());
        if (node.has("availability"))
            operator.setAvailability(node.get("availability").asBoolean());
        return operator;
    }
}