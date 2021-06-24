package com.beadinventory.beadinventory.REST.Domain.Serializers;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class BeadDeserializer extends KeyDeserializer {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object deserializeKey(String s, DeserializationContext deserializationContext) throws IOException {
        return mapper.readValue(s, Bead.class);
    }
}
