package org.deer.assembly.classes;

import static org.deer.assembly.classes.ClassModifiers.finalClass;
import static org.deer.assembly.classes.ClassModifiers.publicClass;
import static org.deer.assembly.classes.constructor.ConstructorModifiers.protectedConstructor;
import static org.deer.assembly.classes.method.MethodModifiers.finalMethod;
import static org.deer.assembly.classes.method.MethodModifiers.publicMethod;
import static org.deer.assembly.classes.method.MethodModifiers.staticMethod;
import static org.deer.assembly.parameter.ParameterModifiers.finalParameter;
import static org.deer.assembly.type.PrimitiveType.BYTE;

import org.deer.assembly.classes.constructor.ConstructorStatement;
import org.deer.assembly.classes.method.MethodStatement;
import org.deer.assembly.parameter.ParameterStatement;
import org.deer.assembly.type.ObjectType;
import org.deer.assembly.type.PrimitiveType;
import org.junit.Test;

public class StatementsTest {

    @Test
    public void testConstructor() {
        System.out.println(new ConstructorStatement("Processor")
                .accessModifier(protectedConstructor())
                .addParameter(new ParameterStatement(new ObjectType("java.lang", "String"), "param1"))
                .addParameter(new ParameterStatement(BYTE,"primitiveOne"))
                .addParameter(new ParameterStatement(new ObjectType("java.lang", "Integer"), "param2")
                        .mutabilityModifier(finalParameter())).assemble());
    }

    @Test
    public void testClass() {
        System.out.println(new ClassStatement("Processor")
                .accessModifier(publicClass())
                .mutabilityModifier(finalClass())
                .assemble());
    }

    @Test
    public void testMethod() {
        System.out.println(new MethodStatement("buildSomething")
                .accessModifier(publicMethod())
                .mutabilityModifier(finalMethod())
                .returnType(new ObjectType("org.deer.assembly", "Type"))
                .scopeModifier(staticMethod()).assemble());
    }
}