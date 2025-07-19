package org.univaq.swa.soccorsowebrest.jackson;

import org.univaq.swa.soccorsowebrest.model.Request;
import org.univaq.swa.soccorsowebrest.model.Mission;
import org.univaq.swa.soccorsowebrest.model.Operator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }

    public ObjectMapperContextResolver() {
        this.mapper = new ObjectMapper();

        // Configurazione base
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Registrazione moduli
        mapper.registerModule(new JavaTimeModule());

        // Modulo per i serializzatori custom
        SimpleModule customSerializer = new SimpleModule("CustomSerializersModule");
        customSerializer.addSerializer(Request.class, new RequestSerializer());
        customSerializer.addDeserializer(Request.class, new RequestDeserializer());
        customSerializer.addSerializer(Mission.class, new MissionSerializer());
        customSerializer.addDeserializer(Mission.class, new MissionDeserializer());
        customSerializer.addSerializer(Operator.class, new OperatorSerializer());
        customSerializer.addDeserializer(Operator.class, new OperatorDeserializer());

        mapper.registerModule(customSerializer);
        mapper.findAndRegisterModules();        
    }
}
