package io.naikan.model.deserializer.json;

import io.naikan.model.Bom;
import io.naikan.model.deserializer.DeserializerException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class DefaultJsonDeserializer extends AbstractJsonDeserializer {

  @Override
  public Bom of(File file) throws DeserializerException {
    try {
      return mapper().readValue(file, Bom.class);
    } catch (IOException e) {
      throw new DeserializerException("Unable to parse BOM from File", e);
    }
  }

  @Override
  public Bom of(byte[] bomBytes) throws DeserializerException {
    try {
      return mapper().readValue(bomBytes, Bom.class);
    } catch (RuntimeException | IOException e) {
      throw new DeserializerException("Unable to parse BOM from byte array", e);
    }
  }

  @Override
  public Bom of(InputStream inputStream) throws DeserializerException {
    try {
      return mapper().readValue(inputStream, Bom.class);
    } catch (IOException e) {
      throw new DeserializerException("Unable to parse BOM from InputStream", e);
    }
  }

  @Override
  public Bom of(Reader reader) throws DeserializerException {
    try {
      return mapper().readValue(reader, Bom.class);
    } catch (IOException e) {
      throw new DeserializerException("Unable to parse BOM from Reader", e);
    }
  }
}