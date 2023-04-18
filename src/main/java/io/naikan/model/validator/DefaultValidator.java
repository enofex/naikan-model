package io.naikan.model.validator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.naikan.model.Bom;
import io.naikan.model.BomSchema;
import io.naikan.model.module.ObjectMapperFactory;
import io.naikan.model.serializer.SerializerFactory;
import io.naikan.model.serializer.json.JsonSerializer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class DefaultValidator extends BomSchema implements Validator {

  private final ObjectMapper mapper;

  public DefaultValidator() {
    this.mapper = ObjectMapperFactory.newObjectMapper();
  }

  @Override
  public List<ValidationException> validate(File file) {
    return validate(file, BomSchema.VERSION_LATEST);
  }

  @Override
  public List<ValidationException> validate(File file, BomSchema.Version schemaVersion) {
    try {
      return validate(FileUtils.readFileToString(file, StandardCharsets.UTF_8.name()),
          schemaVersion);
    } catch (IOException e) {
      throw new ValidationException(e);
    }
  }

  @Override
  public List<ValidationException> validate(byte[] bomBytes) {
    return validate(bomBytes, BomSchema.VERSION_LATEST);
  }

  @Override
  public List<ValidationException> validate(byte[] bomBytes, BomSchema.Version schemaVersion) {
    return validate(new String(bomBytes), schemaVersion);
  }

  @Override
  public List<ValidationException> validate(Reader reader) {
    return validate(reader, BomSchema.VERSION_LATEST);
  }

  @Override
  public List<ValidationException> validate(Reader reader, BomSchema.Version schemaVersion) {
    try {
      return validate(IOUtils.toString(reader), schemaVersion);
    } catch (IOException e) {
      throw new ValidationException(e);
    }
  }

  @Override
  public List<ValidationException> validate(InputStream inputStream) {
    return validate(inputStream, BomSchema.VERSION_LATEST);
  }

  @Override
  public List<ValidationException> validate(InputStream inputStream,
      BomSchema.Version schemaVersion) {
    try {
      return validate(IOUtils.toString(inputStream, StandardCharsets.UTF_8), schemaVersion);
    } catch (IOException e) {
      throw new ValidationException(e);
    }
  }

  @Override
  public List<ValidationException> validate(String bomString, BomSchema.Version schemaVersion) {
    try {
      return validate(this.mapper.readTree(bomString), schemaVersion);
    } catch (JsonProcessingException e) {
      throw new ValidationException(e);
    }
  }

  @Override
  public List<ValidationException> validate(String bomString) {
    try {
      return validate(this.mapper.readTree(bomString), BomSchema.VERSION_LATEST);
    } catch (JsonProcessingException e) {
      throw new ValidationException(e);
    }
  }

  public List<ValidationException> validate(JsonNode bomJson, BomSchema.Version schemaVersion) {
    try {
      return jsonSchema(schemaVersion, this.mapper)
          .validate(this.mapper.readTree(bomJson.toString()))
          .stream()
          .map(message -> new ValidationException(message.getMessage()))
          .toList();
    } catch (IOException e) {
      throw new ValidationException(e);
    }
  }

  @Override
  public boolean isValid(File file) {
    return validate(file).isEmpty();
  }

  @Override
  public boolean isValid(File file, BomSchema.Version schemaVersion) {
    return validate(file, schemaVersion).isEmpty();
  }

  @Override
  public boolean isValid(byte[] bomBytes) {
    return validate(bomBytes).isEmpty();
  }

  @Override
  public boolean isValid(byte[] bomBytes, BomSchema.Version schemaVersion) {
    return validate(bomBytes, schemaVersion).isEmpty();
  }

  @Override
  public boolean isValid(String bomString) {
    return validate(bomString).isEmpty();
  }

  @Override
  public boolean isValid(String bomString, BomSchema.Version schemaVersion) {
    return validate(bomString, schemaVersion).isEmpty();
  }

  @Override
  public boolean isValid(Bom bom) {
    return validate(
        ((JsonSerializer) SerializerFactory.newJsonSerializer()).toJsonString(bom)).isEmpty();
  }

  @Override
  public boolean isValid(Bom bom, Version schemaVersion) {
    return validate(((JsonSerializer) SerializerFactory.newJsonSerializer()).toJsonString(bom),
        schemaVersion).isEmpty();
  }

  @Override
  public boolean isValid(Reader reader) {
    return validate(reader).isEmpty();
  }

  @Override
  public boolean isValid(Reader reader, BomSchema.Version schemaVersion) {
    return validate(reader, schemaVersion).isEmpty();
  }

  @Override
  public boolean isValid(InputStream inputStream) {
    return validate(inputStream).isEmpty();
  }

  @Override
  public boolean isValid(InputStream inputStream, BomSchema.Version schemaVersion) {
    return validate(inputStream, schemaVersion).isEmpty();
  }
}