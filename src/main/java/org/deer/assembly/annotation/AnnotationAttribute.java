package org.deer.assembly.annotation;

import org.deer.assembly.Statement;

public class AnnotationAttribute implements Statement {

    private final String name;
    private final Object value;

    public AnnotationAttribute(final String name, final Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String assemble() {
        return name + " = " + value;
    }
}
