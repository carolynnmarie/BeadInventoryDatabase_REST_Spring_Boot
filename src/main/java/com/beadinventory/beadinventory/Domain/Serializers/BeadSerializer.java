package com.beadinventory.beadinventory.Domain.Serializers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;

public class BeadSerializer extends JsonSerializer<Bead> {

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public void serialize(Bead bead, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer,bead);
        jsonGenerator.writeFieldName(writer.toString());
    }
}
