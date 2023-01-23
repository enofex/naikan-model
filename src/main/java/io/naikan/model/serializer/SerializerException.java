package io.naikan.model.serializer;

public class SerializerException extends Exception {

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