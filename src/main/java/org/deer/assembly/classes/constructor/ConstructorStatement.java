package org.deer.assembly.classes.constructor;

import static org.deer.assembly.Constants.COMMASPACE;
import static org.deer.assembly.Constants.LCB;
import static org.deer.assembly.Constants.LRB;
import static org.deer.assembly.Constants.NL;
import static org.deer.assembly.Constants.RCB;
import static org.deer.assembly.Constants.RRB;
import static org.deer.assembly.Constants.SPACE;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.deer.assembly.Statement;
import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.parameter.ParameterStatement;

public class ConstructorStatement implements Statement {

    private final String forClass;
    private AccessModifier accessModifier;
    private final Set<ParameterStatement> parameterStatements;

    public ConstructorStatement(final String forClass) {
        this.forClass = forClass;
        this.parameterStatements = new LinkedHashSet<>();
    }

    public ConstructorStatement accessModifier(final AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
        return this;
    }

    public ConstructorStatement addParameter(final ParameterStatement parameterStatement) {
        this.parameterStatements.add(parameterStatement);
        return this;
    }

    public String forClassName() {
        return forClass;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Set<ParameterStatement> getParameterStatements() {
        return parameterStatements;
    }



    @Override
    public String assemble() {
        return accessModifier.assemble().concat(SPACE).concat(forClass)
                .concat(LRB)
                .concat(parameterStatements.stream().map(ParameterStatement::assemble).collect(Collectors.joining(COMMASPACE)))
                .concat(RRB)
                .concat(LCB).concat(NL).concat(RCB);
    }
}
