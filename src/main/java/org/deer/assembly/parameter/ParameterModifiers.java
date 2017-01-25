package org.deer.assembly.parameter;

import org.deer.assembly.modifier.MutabilityModifier;

public class ParameterModifiers {

    public static MutabilityModifier finalParameter() {
        return MutabilityModifier.FINAL;
    }

    public static MutabilityModifier nonFinalParameter() {
        return MutabilityModifier.NONFINAL;
    }
}
