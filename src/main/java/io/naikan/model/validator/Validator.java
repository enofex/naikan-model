package io.naikan.model.validator;

import io.naikan.model.Bom;
import io.naikan.model.BomSchema;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public interface Validator {

  List<ValidationException> validate(File file);

  List<ValidationException> validate(File file, BomSchema.Version schemaVersion);

  List<ValidationException> validate(byte[] bomBytes);

  List<ValidationException> validate(byte[] bomBytes, BomSchema.Version schemaVersion);

  List<ValidationException> validate(String bomString);

  List<ValidationException> validate(String bomString, BomSchema.Version schemaVersion);

  List<ValidationException> validate(Reader reader);

  List<ValidationException> validate(Reader reader, BomSchema.Version schemaVersion);

  List<ValidationException> validate(InputStream inputStream);

  List<ValidationException> validate(InputStream inputStream, BomSchema.Version schemaVersion);

  boolean isValid(File file);

  boolean isValid(File file, BomSchema.Version schemaVersion);

  boolean isValid(byte[] bomBytes);

  boolean isValid(byte[] bomBytes, BomSchema.Version schemaVersion);

  boolean isValid(String bomString);

  boolean isValid(String bomString, BomSchema.Version schemaVersion);

  boolean isValid(Bom bom);

  boolean isValid(Bom bom, BomSchema.Version schemaVersion);

  boolean isValid(Reader reader);

  boolean isValid(Reader reader, BomSchema.Version schemaVersion);

  boolean isValid(InputStream inputStream);

  boolean isValid(InputStream inputStream, BomSchema.Version schemaVersion);
}