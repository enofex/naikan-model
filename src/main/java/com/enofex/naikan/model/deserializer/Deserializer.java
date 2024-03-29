package com.enofex.naikan.model.deserializer;

import com.enofex.naikan.model.Bom;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;

public interface Deserializer {

  Bom of(File file) throws DeserializerException;

  Bom of(byte[] bomBytes) throws DeserializerException;

  Bom of(Reader reader) throws DeserializerException;

  Bom of(InputStream inputStream) throws DeserializerException;

  boolean supports(String type);
}