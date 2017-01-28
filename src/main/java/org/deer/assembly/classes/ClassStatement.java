package org.deer.assembly.classes;


import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.joining;
import static org.deer.assembly.Constants.IMPORT;
import static org.deer.assembly.Constants.LCB;
import static org.deer.assembly.Constants.NL;
import static org.deer.assembly.Constants.NL2;
import static org.deer.assembly.Constants.NOTHING;
import static org.deer.assembly.Constants.PACKAGE;
import static org.deer.assembly.Constants.RCB;
import static org.deer.assembly.Constants.SEMICOLON;
import static org.deer.assembly.Constants.SPACE;
import static org.deer.assembly.modifier.MutabilityModifier.NONFINAL;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.deer.assembly.Statement;
import org.deer.assembly.annotation.Annotation;
import org.deer.assembly.classes.attribute.Attribute;
import org.deer.assembly.classes.constructor.ConstructorStatement;
import org.deer.assembly.classes.method.MethodStatement;
import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.packages.PackageCollector;
import org.deer.assembly.packages.PackageStatement;

public class ClassStatement implements Statement, PackageCollector {

    private static final String NAME = "class";

    private final String className;
    private final PackageStatement _package;
    private AccessModifier accessModifier;
    private MutabilityModifier mutabilityModifier;
    private final Set<ConstructorStatement> constructorStatements;
    private final Set<MethodStatement> methodStatements;
    private final Set<Attribute> attributes;
    private final Set<Annotation> annotations;

    public ClassStatement(final String className, final PackageStatement _package) {
        this.className = className;
        this._package = _package;
        this.accessModifier = ClassModifiers.packagePrivateClass();
        this.mutabilityModifier = NONFINAL;
        this.constructorStatements = new LinkedHashSet<>();
        this.methodStatements = new LinkedHashSet<>();
        this.attributes = new LinkedHashSet<>();
        this.annotations = new LinkedHashSet<>();
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

    public ClassStatement addAttribute(final Attribute attribute) {
        this.attributes.add(attribute);
        return this;
    }

    public ClassStatement addAnnotation(final Annotation annotation) {
        this.annotations.add(annotation);
        return this;
    }

    public String assemble() {
        return packageStatement()
                .concat(importStatements())
                .concat(annotationsBlock(annotations))
                .concat(accessModifier.assemble()).concat(SPACE)
                .concat(mutabilityModifier.assemble()).concat(SPACE)
                .concat(NAME).concat(SPACE)
                .concat(className).concat(SPACE).concat(LCB).concat(NL)
                .concat(attributesBlocks())
                .concat(constructorBlocks())
                .concat(methodStatementsBlock())
                .concat(RCB);
    }

    private String methodStatementsBlock() {
        return block(methodStatements.stream().map(Statement::assemble).collect(joining(NL)));
    }

    private String constructorBlocks() {
        return block(constructorStatements.stream().map(Statement::assemble).collect(joining(NL)));
    }

    private String attributesBlocks() {
        return block(attributes.stream().map(Attribute::assemble).collect(joining(NL)));
    }

    private String packageStatement() {
        if (_package != null && !_package.getName().isEmpty()) {
            return PACKAGE.concat(SPACE).concat(_package.getName()).concat(SEMICOLON).concat(NL2);
        }
        return NOTHING;
    }

    private String importStatements() {
        return Stream.concat(
                Stream.concat(
                        constructorTypesPackageNames(constructorStatements).stream(),
                        methodTypesPackageNames(methodStatements).stream()),
                attributeTypesPackageNames(attributes).stream())
                .map(packageName -> IMPORT.concat(SPACE).concat(packageName).concat(SEMICOLON))
                .collect(Collectors.joining(NL)).concat(NL2);

    }
}
