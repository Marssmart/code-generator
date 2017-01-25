package org.deer.assembly.modifier;

public enum AccessModifier implements Modifier {

    PUBLIC("public"),
    PRIVATE("private"),
    PACKAGE_PRIVATE(""),
    PROTECTED("protected");

    private final String name;

    private AccessModifier(final String name) {
        this.name = name;
    }

    public String assemble() {
        return name;
    }
}
