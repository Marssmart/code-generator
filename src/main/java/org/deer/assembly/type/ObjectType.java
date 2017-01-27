package org.deer.assembly.type;

import org.deer.assembly.packages.PackageStatement;

public class ObjectType implements Type {

    private final String name;
    private final PackageStatement _package;

    public ObjectType(final PackageStatement _package, final String name) {
        this.name=name;
        this._package=_package;
    }

    public PackageStatement getPackage() {
        return _package;
    }

    public String getName() {
        return name;
    }

    @Override
    public String assemble() {
        return name;
    }
}
