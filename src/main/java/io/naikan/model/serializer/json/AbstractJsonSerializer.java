package io.naikan.model.serializer.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.naikan.model.Bom;
import io.naikan.model.BomSchema;
import io.naikan.model.ObjectMapperFactory;
import io.naikan.model.serializer.SerializerException;

import java.lang.reflect.Field;

abstract class AbstractJsonSerializer extends BomSchema implements JsonSerializer {

    private final ObjectMapper mapper;
    private final DefaultPrettyPrinter prettyPrinter;

    AbstractJsonSerializer() {
        this.mapper = ObjectMapperFactory.newObjectMapper();
        this.prettyPrinter = new DefaultPrettyPrinter();
        this.prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
    }

    ObjectMapper getMapper() {
        return this.mapper;
    }

    String toJson(Bom bom, boolean prettyPrint) throws SerializerException {
        try {
            if (prettyPrint) {
                return this.mapper.writer(this.prettyPrinter).writeValueAsString(bom);
            }
            return this.mapper.writeValueAsString(bom);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }

    Bom injectBomFormatAndSpecVersion(Bom bom) throws SerializerException {
        try {
            Field field;
            field = Bom.class.getDeclaredField("bomFormat");
            field.setAccessible(true);
            field.set(bom, "Naikan");
            field = Bom.class.getDeclaredField("specVersion");
            field.setAccessible(true);
            field.set(bom, getSchemaVersion().version());
            return bom;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new SerializerException(e);
        }
    }

    Bom modifyBom(Bom bom) {
        Bom modifiedBom = null;

        try {
            modifiedBom = injectBomFormatAndSpecVersion(bom);
        } catch (SerializerException ignored) {
        }

        return modifiedBom != null ? modifiedBom : bom;
    }
}