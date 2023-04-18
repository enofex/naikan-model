package io.naikan.model.module;

import java.io.IOException;
import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class ObjectMapperFactory {

  private ObjectMapperFactory() {
  }

  public static ObjectMapper newObjectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.registerModule(new NaikanModule());
    mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

    SimpleModule stringModule = new SimpleModule();
    stringModule.addSerializer(new TrimStringSerializer());

    mapper.registerModule(stringModule);

    return mapper;
  }

  private static final class TrimStringSerializer extends StdScalarSerializer<Object> {

    @Serial
    private static final long serialVersionUID = 1L;

    TrimStringSerializer() {
      super(String.class, false);
    }

    public void serialize(String value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
      if (value != null) {
        gen.writeString(value.trim()
            .replace("\r\n", " ")
            .replace("\n", " ")
            .replace("\t", " ")
            .replace("\r", " ")
            .replaceAll(" +", " "));
      }
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
      if (value instanceof String) {
        serialize((String) value, gen, provider);
      }
    }
  }
}
