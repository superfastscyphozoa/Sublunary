package net.superfastscyphozoa.sublunary.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum CrowVariant {
    BLACK(0),
    BROWN(1),
    WHITE(2);

    private static final CrowVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(CrowVariant::getId)).toArray(CrowVariant[]::new);
    private final int id;

    CrowVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CrowVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
