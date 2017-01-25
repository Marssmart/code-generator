package org.deer.assembly.classes.constructor;

import org.deer.assembly.modifier.AccessModifier;

public final class ConstructorModifiers {

    private ConstructorModifiers() {
    }

    public static AccessModifier publicConstructor() {
        return AccessModifier.PUBLIC;
    }

    public static AccessModifier packagePrivateConstructor() {
        return AccessModifier.PACKAGE_PRIVATE;
    }

    public static AccessModifier protectedConstructor() {
        return AccessModifier.PROTECTED;
    }
}
