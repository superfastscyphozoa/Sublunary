package net.superfastscyphozoa.sublunary.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum PasserineVariant {
    BLACK(0),
    BROWN(1),
    WHITE(2);

    private static final PasserineVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(PasserineVariant::getId)).toArray(PasserineVariant[]::new);
    private final int id;

    PasserineVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static PasserineVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
