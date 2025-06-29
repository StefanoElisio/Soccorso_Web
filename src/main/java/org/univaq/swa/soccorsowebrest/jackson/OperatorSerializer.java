package org.univaq.swa.soccorsowebrest.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

import org.univaq.swa.soccorsowebrest.model.Operator;

public class OperatorSerializer extends JsonSerializer<Operator> {

    @Override
    public void serialize(Operator operator, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();

        jgen.writeStringField("uid", operator.getUid());
        jgen.writeStringField("name", operator.getName());
        jgen.writeStringField("username", operator.getUsername());
        jgen.writeStringField("surname", operator.getSurname());
        jgen.writeObjectField("birthdate", operator.getBirthdate());
        jgen.writeObjectField("patents", operator.getPatents());
        jgen.writeObjectField("skills", operator.getSkills());
        jgen.writeBooleanField("availability", operator.getAvailability());
        jgen.writeEndObject();
    }
}