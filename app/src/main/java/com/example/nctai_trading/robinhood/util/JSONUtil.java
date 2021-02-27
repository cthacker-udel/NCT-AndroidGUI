package com.example.nctai_trading.robinhood.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class JSONUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static <T> Optional<T> deserializeString(final String jsonString,
                                                    final TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(jsonString)) {
            return Optional.empty();
        }

        try {
            return Optional.of(objectMapper.readValue(jsonString, typeReference));
        } catch (IOException e) {
        }

        return Optional.empty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static <T> Optional<T> deserializeObject(final String jsonData, final Class<T> valueType) {
        try {
            return Optional.of(objectMapper.readValue(jsonData, valueType));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}