package by.shestopalov.project.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateSerializer extends StdSerializer<Date> {
    private static final long serialVersionUID = 1L;
    public DateSerializer(){
        super(Date.class);
    }
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider sp) throws IOException
    {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gen.writeString(formatter.format(value));
    }
}
