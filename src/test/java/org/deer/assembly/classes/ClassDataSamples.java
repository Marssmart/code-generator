package org.deer.assembly.classes;

import static org.deer.assembly.classes.ClassModifiers.finalClass;
import static org.deer.assembly.classes.ClassModifiers.publicClass;
import static org.deer.assembly.classes.constructor.ConstructorModifiers.publicConstructor;
import static org.deer.assembly.classes.method.MethodModifiers.finalMethod;
import static org.deer.assembly.classes.method.MethodModifiers.privateMethod;
import static org.deer.assembly.classes.method.MethodModifiers.publicMethod;
import static org.deer.assembly.classes.method.MethodModifiers.staticMethod;
import static org.deer.assembly.parameter.ParameterModifiers.finalParameter;
import static org.deer.assembly.type.PrimitiveType.BYTE;

import org.deer.assembly.classes.attribute.Attribute;
import org.deer.assembly.classes.constructor.ConstructorStatement;
import org.deer.assembly.classes.method.MethodStatement;
import org.deer.assembly.packages.PackageStatement;
import org.deer.assembly.parameter.ParameterStatement;
import org.deer.assembly.type.ObjectType;
import org.deer.assembly.type.PrimitiveType;

public class ClassDataSamples {

    public static final ParameterStatement PARAMETER_STATEMENT_ONE =
            new ParameterStatement(new ObjectType(new PackageStatement("java.lang"), "String"), "param1");

    public static final ParameterStatement PARAMETER_STATEMENT_TWO = new ParameterStatement(BYTE, "primitiveOne");

    public static final ParameterStatement PARAMETER_STATEMENT_THREE =
            new ParameterStatement(new ObjectType(new PackageStatement("java.lang"), "Integer"), "param2")
                    .mutabilityModifier(finalParameter());

    public static final Attribute ATTRIBUTE_ONE = new Attribute("firstParam",
            new ObjectType(new PackageStatement("org.some.other.organization"), "SomeType"));
    public static final Attribute ATTRIBUTE_TWO = new Attribute("secondParam",
            new ObjectType(new PackageStatement("org.some.other.company"), "SomeOtherType"));
    public static final Attribute ATTRIBUTE_THREE =
            new Attribute("thirdParam", PrimitiveType.FLOAT).accessModifier(privateMethod())
                    .mutabilityModifier(finalParameter());

    public static final MethodStatement METHOD_STATEMENT = new MethodStatement("buildSomething")
            .accessModifier(publicMethod())
            .mutabilityModifier(finalMethod())
            .returnType(new ObjectType(new PackageStatement("org.deer.assembly"), "Type"))
            .scopeModifier(staticMethod());

    public static final ConstructorStatement CONSTRUCTOR = new ConstructorStatement("Processor")
            .accessModifier(publicConstructor())
            .addParameter(PARAMETER_STATEMENT_ONE)
            .addParameter(PARAMETER_STATEMENT_TWO)
            .addParameter(PARAMETER_STATEMENT_THREE);


    public static final ClassStatement PROCESSOR_CLASS =
            new ClassStatement("Processor", new PackageStatement("org.deer.samples"))
                    .accessModifier(publicClass())
                    .mutabilityModifier(finalClass())
                    .addConstructor(CONSTRUCTOR)
                    .addMethod(METHOD_STATEMENT)
                    .addAttribute(ATTRIBUTE_ONE)
                    .addAttribute(ATTRIBUTE_TWO)
                    .addAttribute(ATTRIBUTE_THREE);
}
