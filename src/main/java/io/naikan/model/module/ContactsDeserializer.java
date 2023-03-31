package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.Contact;
import io.naikan.model.Contacts;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class ContactsDeserializer extends AbstractDeserializer<Contacts> {

    @Serial
    private static final long serialVersionUID = 1L;

    static final ContactsDeserializer INSTANCE = new ContactsDeserializer();

    ContactsDeserializer() {
        super(Contacts.class, Contacts.empty());
    }

    @Override
    public Contacts deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        Contact[] contacts = jsonParser.readValueAs(Contact[].class);

        return new Contacts(List.of(contacts));
    }

}
