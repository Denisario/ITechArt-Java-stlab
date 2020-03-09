package by.shestopalov.project.json;


import by.shestopalov.project.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Serializer {
    private static final Logger log = Logger.getLogger(Serializer.class);
    public static String serialize(Object obj, String path) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(obj);
        mapper.writeValue(new File(path), obj);
        log.info("User serialize the data");
        return json;
    }

    public static User deserialize(String data) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        log.info("User deserialize the data");
        return mapper.readValue(data, User.class);
    }
}
