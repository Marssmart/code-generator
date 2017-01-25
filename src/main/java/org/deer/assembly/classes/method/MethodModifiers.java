package org.deer.assembly.classes.method;

import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.modifier.ScopeModifier;

public class MethodModifiers {

    private MethodModifiers() {
    }

    public static AccessModifier publicMethod() {
        return AccessModifier.PUBLIC;
    }

    public static AccessModifier packagePrivateMethod() {
        return AccessModifier.PACKAGE_PRIVATE;
    }

    public static AccessModifier protectedMethod() {
        return AccessModifier.PROTECTED;
    }

    public static AccessModifier privateMethod() {
        return AccessModifier.PRIVATE;
    }

    public static MutabilityModifier finalMethod() {
        return MutabilityModifier.FINAL;
    }

    public static MutabilityModifier nonFinalMethod() {
        return MutabilityModifier.NONFINAL;
    }

    public static ScopeModifier staticMethod(){
        return ScopeModifier.STATIC;
    }

    public static ScopeModifier nonStaticMethod(){
        return ScopeModifier.NONSTATIC;
    }
}
