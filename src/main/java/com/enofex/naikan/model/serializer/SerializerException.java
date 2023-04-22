package com.enofex.naikan.model.serializer;

import java.io.Serial;

public class SerializerException extends Exception {

  @Serial
  private static final long serialVersionUID = 1L;

  public SerializerException(String message) {
    super(message);
  }

  public SerializerException(Throwable cause) {
    super(cause);
  }

  public SerializerException(String message, Throwable cause) {
    super(message, cause);
  }
}