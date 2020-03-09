package by.shestopalov.project.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateDeserializer extends StdDeserializer<Date> {
    private static final long serialVersionUID = 1L;
    protected DateDeserializer() {
        super(Date.class);
    }
    @SneakyThrows
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return convertUtilToSql(formatter.parse(jp.readValueAs(String.class)));
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}