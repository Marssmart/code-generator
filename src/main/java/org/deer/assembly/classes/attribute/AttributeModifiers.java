package org.deer.assembly.classes.attribute;

import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.modifier.ScopeModifier;

public class AttributeModifiers {

    public static AccessModifier publicAttribute() {
        return AccessModifier.PUBLIC;
    }

    public static AccessModifier packagePrivateAttribute() {
        return AccessModifier.PACKAGE_PRIVATE;
    }

    public static AccessModifier protectedAttribute() {
        return AccessModifier.PROTECTED;
    }

    public static AccessModifier privateAttribute() {
        return AccessModifier.PRIVATE;
    }

    public static MutabilityModifier finalAttribute() {
        return MutabilityModifier.FINAL;
    }

    public static MutabilityModifier nonFinalAttribute() {
        return MutabilityModifier.NONFINAL;
    }

    public static ScopeModifier staticAttribute(){
        return ScopeModifier.STATIC;
    }

    public static ScopeModifier nonStaticAttribute(){
        return ScopeModifier.NONSTATIC;
    }
}
