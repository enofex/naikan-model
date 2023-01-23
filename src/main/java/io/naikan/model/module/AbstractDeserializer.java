package io.naikan.model.module;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

abstract class AbstractDeserializer<T> extends StdDeserializer<T> {

    private final T empty;

    protected AbstractDeserializer(Class clazz, T empty) {
        super(clazz);
        this.empty = empty;
    }

    @Override
    public T getNullValue(DeserializationContext ctx) {
        return this.empty;
    }
}
