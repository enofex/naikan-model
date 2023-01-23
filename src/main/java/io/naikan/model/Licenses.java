package io.naikan.model;

import java.util.List;

public final class Licenses extends AbstractContainer<License> {

    private static final Licenses NO_LICENSES = new Licenses(List.of());

    public Licenses(List<License> licenses) {
        super(licenses);
    }

    public static Licenses empty() {
        return NO_LICENSES;
    }
}
