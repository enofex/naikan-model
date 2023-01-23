package io.naikan.model;

import java.util.List;

public final class Developers extends AbstractContainer<Developer> {

    private static final Developers NO_DEVELOPERS = new Developers(List.of());

    public Developers(List<Developer> developers) {
        super(developers);
    }

    public static Developers empty() {
        return NO_DEVELOPERS;
    }
}
