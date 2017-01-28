package org.deer.assembly.classes.attribute;

import static org.deer.assembly.Constants.SEMICOLON;
import static org.deer.assembly.Constants.SPACE;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.deer.assembly.Statement;
import org.deer.assembly.annotation.Annotation;
import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.type.Type;

public class Attribute implements Statement {

    private final String name;
    private final Type type;
    private AccessModifier accessModifier;
    private MutabilityModifier mutabilityModifier;
    private final Set<Annotation> annotations;

    public Attribute(final String name, final Type type) {
        this.name = name;
        this.type = type;
        this.accessModifier = AccessModifier.PACKAGE_PRIVATE;
        this.mutabilityModifier = MutabilityModifier.NONFINAL;
        this.annotations = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Attribute accessModifier(final AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
        return this;
    }

    public MutabilityModifier getMutabilityModifier() {
        return mutabilityModifier;
    }

    public Attribute mutabilityModifier(final MutabilityModifier mutabilityModifier) {
        this.mutabilityModifier = mutabilityModifier;
        return this;
    }

    public Attribute addAnnotation(final Annotation annotation) {
        this.annotations.add(annotation);
        return this;
    }

    @Override
    public String assemble() {
        return annotationsBlock(annotations).concat(accessModifierString())
                .concat(mutabilityModifierString())
                .concat(type.assemble()).concat(SPACE)
                .concat(name).concat(SEMICOLON);
    }

    private String accessModifierString() {
        return Optional.ofNullable(accessModifier)
                .map(AccessModifier::assemble)
                .filter(StringUtils::isNotEmpty)
                .map(string -> string.concat(SPACE))
                .orElse("");
    }

    private String mutabilityModifierString() {
        return Optional.ofNullable(mutabilityModifier)
                .map(MutabilityModifier::assemble)
                .filter(StringUtils::isNotEmpty)
                .map(string -> string.concat(SPACE))
                .orElse("");
    }
}
