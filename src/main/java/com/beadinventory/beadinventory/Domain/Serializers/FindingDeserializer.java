package com.beadinventory.beadinventory.Domain.Serializers;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FindingDeserializer extends KeyDeserializer {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object deserializeKey(String s, DeserializationContext deserializationContext) throws IOException {
        return mapper.readValue(s,Finding.class);
    }
}
