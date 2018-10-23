package com.beadinventory.beadinventory.Domain.Serializers;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;

public class FindingSerializer extends JsonSerializer<Finding> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(Finding finding, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer,finding);
        jsonGenerator.writeFieldName(writer.toString());
    }
}
