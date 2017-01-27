package org.deer.assembly.parameter;

import static org.deer.assembly.Constants.SPACE;

import org.deer.assembly.Statement;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.type.Type;

public class ParameterStatement implements Statement {

    private final Type type;
    private final String name;
    private MutabilityModifier mutabilityModifier;

    public ParameterStatement(final Type type, final String name) {
        this.type = type;
        this.name = name;
    }

    public ParameterStatement mutabilityModifier(final MutabilityModifier mutabilityModifier) {
        this.mutabilityModifier = mutabilityModifier;
        return this;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public MutabilityModifier getMutabilityModifier() {
        return mutabilityModifier;
    }

    @Override
    public String assemble() {
        return (mutabilityModifier == null
                ? ""
                : mutabilityModifier.assemble().concat(SPACE))
                .concat(type.assemble()).concat(SPACE)
                .concat(name);
    }
}
