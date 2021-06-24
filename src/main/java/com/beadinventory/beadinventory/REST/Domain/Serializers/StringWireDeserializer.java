package com.beadinventory.beadinventory.REST.Domain.Serializers;

import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class StringWireDeserializer extends KeyDeserializer {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object deserializeKey(String s, DeserializationContext deserializationContext) throws IOException {
        return mapper.readValue(s,StringWire.class);
    }
}
