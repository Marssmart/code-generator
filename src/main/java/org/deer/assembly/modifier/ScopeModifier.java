package org.deer.assembly.modifier;

public enum ScopeModifier implements Modifier {

    STATIC("static"),
    NONSTATIC("");

    private final String name;

    private ScopeModifier(final String name) {
        this.name = name;
    }

    @Override
    public String assemble() {
        return name;
    }
}
