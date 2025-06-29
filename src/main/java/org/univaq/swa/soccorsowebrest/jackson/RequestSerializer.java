import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

import org.univaq.swa.soccorsowebrest.model.Request;

public class RequestSerializer extends JsonSerializer<Request> {

    @Override
    public void serialize(Request request, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();

        // Serializza solo i campi non nulli
        jgen.writeStringField("uid", request.getUid());
        jgen.writeStringField("name", request.getName());
        jgen.writeStringField("email", request.getEmail());
        jgen.writeObjectField("location", request.getLocation());
        jgen.writeStringField("description", request.getDescription());
        jgen.writeObjectField("time", request.getTime());
        jgen.writeObjectField("position", request.getPosition());
        jgen.writeObjectField("photo", request.getPhoto());
        jgen.writeObjectField("status", request.getStatus());
        jgen.writeStringField("admin_uid", request.getAdmin_uid());
        jgen.writeNumberField("success_lvl", request.getSuccess_lvl());

        jgen.writeEndObject();
    }
}