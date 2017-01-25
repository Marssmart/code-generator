package org.deer.assembly.modifier;

public enum MutabilityModifier implements Modifier {

    FINAL("final"),
    NONFINAL("");

    private final String name;

    private MutabilityModifier(final String name) {
        this.name = name;
    }

    @Override
    public String assemble() {
        return name;
    }
}
