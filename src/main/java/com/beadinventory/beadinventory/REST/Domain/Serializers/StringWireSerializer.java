package com.beadinventory.beadinventory.REST.Domain.Serializers;

import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.StringWriter;

public class StringWireSerializer extends JsonSerializer<StringWire> {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public void serialize(StringWire stringWire, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer,stringWire);
        jsonGenerator.writeFieldName(writer.toString());
    }
}
