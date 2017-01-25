package org.deer.assembly.type;

public class ObjectType implements Type {

    private final String name;
    private final String _package;

    public ObjectType(final String _package,final String name) {
        this.name=name;
        this._package=_package;
    }

    public String getPackage() {
        return _package;
    }

    @Override
    public String assemble() {
        return name;
    }
}
