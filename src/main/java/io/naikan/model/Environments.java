package io.naikan.model;

import java.util.List;

public final class Environments extends AbstractContainer<Environment> {

    private static final Environments NO_ENVIRONMENTS = new Environments(List.of());

    public Environments(List<Environment> integrations) {
        super(integrations);
    }

    public static Environments empty() {
        return NO_ENVIRONMENTS;
    }
}
