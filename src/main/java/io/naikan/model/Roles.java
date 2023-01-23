package io.naikan.model;

import java.util.List;

public final class Roles extends AbstractContainer<String> {

    private static final Roles NO_ROLES = new Roles(List.of());

    public Roles(List<String> roles) {
        super(roles);
    }

    public static Roles empty() {
        return NO_ROLES;
    }
}
