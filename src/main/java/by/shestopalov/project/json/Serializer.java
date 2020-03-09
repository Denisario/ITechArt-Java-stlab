package by.shestopalov.project.json;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Serializer {
    public static void serialize(Object obj, String path) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(obj);
        mapper.writeValue(new File(path), obj);

    }
}
