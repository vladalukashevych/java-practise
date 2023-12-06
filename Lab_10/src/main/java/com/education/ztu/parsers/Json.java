package com.education.ztu.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static String JavaToJson(Object object) throws JsonProcessingException {
        JsonNode node = objectMapper.valueToTree(object);
        ObjectWriter objectWriter = objectMapper.writer();
        return objectWriter.writeValueAsString(node);
    }

    public static <T> T JsonToJava(String json, Class<T> clazz) throws JsonProcessingException {

        JsonNode jsonRootNode = objectMapper.readTree(json);
        T object = objectMapper.treeToValue(jsonRootNode, clazz);
        return object;
    }

}
