package org.deer.assembly.type;

public enum PrimitiveType implements Type {

    INT("int"),
    SHORT("short"),
    BYTE("byte"),
    FLOAT("float"),
    DOUBLE("double"),
    CHAR("char"),
    VOID("void");

    private final String name;

    private PrimitiveType(final String name) {
        this.name = name;
    }

    @Override
    public String assemble() {
        return name;
    }
}
