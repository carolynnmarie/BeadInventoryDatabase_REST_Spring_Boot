package com.beadinventory.beadinventory.Domain.Serializers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class BeadDeserializer extends KeyDeserializer {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object deserializeKey(String s, DeserializationContext deserializationContext) throws IOException {
        return mapper.readValue(s, Bead.class);
    }
}
