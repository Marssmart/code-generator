package org.deer.assembly.classes;

import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;

public final class ClassModifiers {

    private ClassModifiers() {
    }

    public static AccessModifier publicClass() {
        return AccessModifier.PUBLIC;
    }

    public static AccessModifier packagePrivateClass() {
        return AccessModifier.PACKAGE_PRIVATE;
    }

    public static AccessModifier protectedClass() {
        return AccessModifier.PROTECTED;
    }

    public static MutabilityModifier finalClass() {
        return MutabilityModifier.FINAL;
    }

    public static MutabilityModifier nonFinalClass() {
        return MutabilityModifier.NONFINAL;
    }
}
