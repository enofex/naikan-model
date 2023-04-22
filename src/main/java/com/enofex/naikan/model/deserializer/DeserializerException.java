package com.enofex.naikan.model.deserializer;

import java.io.Serial;

public class DeserializerException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1L;

  public DeserializerException(String message) {
    super(message);
  }

  public DeserializerException(Throwable cause) {
    super(cause);
  }

  public DeserializerException(String message, Throwable cause) {
    super(message, cause);
  }
}