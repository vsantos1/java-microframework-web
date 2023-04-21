package com.vsantos1.legacy.core.parser;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;

public class Json {

    private static final Gson GSON = new Gson();
    private static final StringBuilder BUILDER = new StringBuilder();

    public Json() {
    }

    public static <T> T parseToObject(BufferedReader reader, Class<T> target) throws IOException {

        String line;

        for (line = reader.readLine(); line != null; line = reader.readLine()) {
            BUILDER.append(line);
        }

        String json = BUILDER.toString();
        return GSON.fromJson(json, target);
    }



    public static String parseToJson(Object object) {
        return GSON.toJson(object);
    }
}
