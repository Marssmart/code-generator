package org.deer.assembly.parameter;

import static org.deer.assembly.Constants.SPACE;

import java.util.HashSet;
import java.util.Set;
import org.deer.assembly.Statement;
import org.deer.assembly.annotation.Annotation;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.type.Type;

public class ParameterStatement implements Statement {

    private final Type type;
    private final String name;
    private MutabilityModifier mutabilityModifier;
    private final Set<Annotation> annotations;

    public ParameterStatement(final Type type, final String name) {
        this.type = type;
        this.name = name;
        this.annotations = new HashSet<>();
    }

    public ParameterStatement addAnnotation(final Annotation annotation) {
        this.annotations.add(annotation);
        return this;
    }

    public ParameterStatement mutabilityModifier(final MutabilityModifier mutabilityModifier) {
        this.mutabilityModifier = mutabilityModifier;
        return this;
    }

    public Set<Annotation> getAnnotations() {
        return annotations;
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
        return annotationsInline(annotations).concat(mutabilityModifier == null
                ? ""
                : mutabilityModifier.assemble().concat(SPACE))
                .concat(type.assemble()).concat(SPACE)
                .concat(name);
    }
}
