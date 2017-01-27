package org.deer.assembly.packages;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.deer.assembly.classes.attribute.Attribute;
import org.deer.assembly.classes.constructor.ConstructorStatement;
import org.deer.assembly.classes.method.MethodStatement;
import org.deer.assembly.parameter.ParameterStatement;
import org.deer.assembly.type.ObjectType;
import org.deer.assembly.type.PrimitiveType;
import org.deer.assembly.type.Type;

public interface PackageCollector {

    default Set<String> constructorTypesPackageNames(final Set<ConstructorStatement> constructors) {
        return createPackageNamesFromTypes(constructors.stream().map(ConstructorStatement::getParameterStatements)
                .flatMap(Collection::stream)
                .map(ParameterStatement::getType));
    }

    default Set<String> methodTypesPackageNames(final Set<MethodStatement> methodStatements) {
        return createPackageNamesFromTypes(Stream.concat(
                methodReturnTypesStream(methodStatements),
                methodParameterTypesStream(methodStatements)));
    }

    default Set<String> attributeTypesPackageNames(final Set<Attribute> attributes) {
        return createPackageNamesFromTypes(attributes.stream().map(Attribute::getType));
    }

    static Set<String> createPackageNamesFromTypes(final Stream<Type> typesStream) {
        return typesStream.filter(filterNonPrimitives())
                .filter(filterObjective())
                .map(ObjectType.class::cast)
                .map(objectType -> objectType.getPackage().getName().concat(".").concat(objectType.getName()))
                .collect(toSet());
    }

    static Stream<Type> methodParameterTypesStream(final Set<MethodStatement> methodStatements) {
        return methodStatements.stream().map(MethodStatement::getParameterStatements)
                .flatMap(Collection::stream)
                .map(ParameterStatement::getType);
    }

    static Stream<Type> methodReturnTypesStream(final Set<MethodStatement> methodStatements) {
        return methodStatements.stream().map(MethodStatement::getReturnType);
    }

    static Predicate<Type> filterObjective() {
        return type -> type instanceof ObjectType;
    }

    static Predicate<Type> filterNonPrimitives() {
        return type -> !(type instanceof PrimitiveType);
    }
}
