package org.deer.assembly.classes;


import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.joining;
import static org.deer.assembly.Constants.LCB;
import static org.deer.assembly.Constants.NL;
import static org.deer.assembly.Constants.RCB;
import static org.deer.assembly.Constants.SPACE;
import static org.deer.assembly.modifier.MutabilityModifier.NONFINAL;

import java.util.LinkedHashSet;
import java.util.Set;
import org.deer.assembly.Statement;
import org.deer.assembly.classes.constructor.ConstructorStatement;
import org.deer.assembly.classes.method.MethodStatement;
import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;

public class ClassStatement implements Statement {

    private static final String NAME = "class";

    private final String className;
    private AccessModifier accessModifier;
    private MutabilityModifier mutabilityModifier;
    private final Set<ConstructorStatement> constructorStatements;
    private final Set<MethodStatement> methodStatements;

    public ClassStatement(final String className) {
        this.className = className;
        this.accessModifier = ClassModifiers.packagePrivateClass();
        this.mutabilityModifier = NONFINAL;
        this.constructorStatements = new LinkedHashSet<>();
        this.methodStatements = new LinkedHashSet<>();
    }

    public ClassStatement accessModifier(final AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
        return this;
    }

    public ClassStatement mutabilityModifier(final MutabilityModifier mutabilityModifier) {
        this.mutabilityModifier = mutabilityModifier;
        return this;
    }

    public ClassStatement addConstructor(final ConstructorStatement statement) {
        checkArgument(className.equals(statement.forClassName()), "Its out of my class bro :[%s vs %s]", className,
                statement.forClassName());
        this.constructorStatements.add(statement);
        return this;
    }

    public ClassStatement addMethod(final MethodStatement statement) {
        this.methodStatements.add(statement);
        return this;
    }

    public String assemble() {
        return accessModifier.assemble().concat(SPACE)
                .concat(mutabilityModifier.assemble()).concat(SPACE)
                .concat(NAME).concat(SPACE)
                .concat(className).concat(SPACE).concat(LCB)
                .concat(block(constructorStatements.stream().map(Statement::assemble).collect(joining(NL)))
                        .concat(block(methodStatements.stream().map(Statement::assemble).collect(joining(NL))))
                        .concat(RCB));
    }
}
