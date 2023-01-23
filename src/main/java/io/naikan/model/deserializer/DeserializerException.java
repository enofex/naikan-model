package io.naikan.model.deserializer;

public class DeserializerException extends RuntimeException {

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