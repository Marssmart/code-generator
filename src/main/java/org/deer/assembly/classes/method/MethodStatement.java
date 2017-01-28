package org.deer.assembly.classes.method;

import static org.deer.assembly.Constants.COMMASPACE;
import static org.deer.assembly.Constants.LCB;
import static org.deer.assembly.Constants.LRB;
import static org.deer.assembly.Constants.NL;
import static org.deer.assembly.Constants.RCB;
import static org.deer.assembly.Constants.RRB;
import static org.deer.assembly.Constants.SPACE;
import static org.deer.assembly.modifier.ScopeModifier.STATIC;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.deer.assembly.Statement;
import org.deer.assembly.annotation.Annotation;
import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.modifier.ScopeModifier;
import org.deer.assembly.parameter.ParameterStatement;
import org.deer.assembly.type.Type;

public class MethodStatement implements Statement {

    private final String name;
    private Type returnType;
    private ScopeModifier scopeModifier;
    private MutabilityModifier mutabilityModifier;
    private AccessModifier accessModifier;
    private final Set<ParameterStatement> parameterStatements;
    private final Set<Annotation> annotations;

    public MethodStatement(final String name) {
        this.name = name;
        this.parameterStatements = new HashSet<>();
        this.annotations = new HashSet<>();
    }

    public MethodStatement addParameter(final ParameterStatement parameterStatement) {
        this.parameterStatements.add(parameterStatement);
        return this;
    }

    public MethodStatement addAnnotation(final Annotation annotation) {
        this.annotations.add(annotation);
        return this;
    }

    public MethodStatement accessModifier(final AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
        return this;
    }

    public MethodStatement returnType(final Type returnType) {
        this.returnType = returnType;
        return this;
    }

    public MethodStatement scopeModifier(final ScopeModifier scopeModifier) {
        this.scopeModifier = scopeModifier;
        return this;
    }

    public MethodStatement mutabilityModifier(final MutabilityModifier mutabilityModifier) {
        this.mutabilityModifier = mutabilityModifier;
        return this;
    }

    public String getName() {
        return name;
    }

    public Type getReturnType() {
        return returnType;
    }

    public ScopeModifier getScopeModifier() {
        return scopeModifier;
    }

    public MutabilityModifier getMutabilityModifier() {
        return mutabilityModifier;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Set<ParameterStatement> getParameterStatements() {
        return parameterStatements;
    }

    @Override
    public String assemble() {
        return annotationsBlock(annotations).concat(accessModifier.assemble()).concat(SPACE)
                .concat(scopeModifier.assemble()).concat(SPACE)
                .concat(STATIC == scopeModifier
                        ? ""
                        : mutabilityModifier.assemble().concat(SPACE))
                .concat(returnType.assemble()).concat(SPACE)
                .concat(name)
                .concat(LRB)
                .concat(parameterStatements.stream().map(ParameterStatement::assemble)
                        .collect(Collectors.joining(COMMASPACE)))
                .concat(RRB).concat(LCB).concat(NL)
                .concat(RCB);
    }
}
