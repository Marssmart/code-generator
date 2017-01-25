package org.deer.assembly.classes.method;

import static org.deer.assembly.Constants.LCB;
import static org.deer.assembly.Constants.LRB;
import static org.deer.assembly.Constants.NL;
import static org.deer.assembly.Constants.RCB;
import static org.deer.assembly.Constants.RRB;
import static org.deer.assembly.Constants.SPACE;
import static org.deer.assembly.modifier.ScopeModifier.STATIC;

import org.deer.assembly.Statement;
import org.deer.assembly.modifier.AccessModifier;
import org.deer.assembly.modifier.MutabilityModifier;
import org.deer.assembly.modifier.ScopeModifier;
import org.deer.assembly.type.Type;

public class MethodStatement implements Statement {

    private final String name;
    private Type returnType;
    private ScopeModifier scopeModifier;
    private MutabilityModifier mutabilityModifier;

    private AccessModifier accessModifier;

    public MethodStatement(final String name) {
        this.name = name;
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

    @Override
    public String assemble() {
        return accessModifier.assemble().concat(SPACE)
                .concat(scopeModifier.assemble()).concat(SPACE)
                .concat(STATIC == scopeModifier
                        ? ""
                        : mutabilityModifier.assemble().concat(SPACE))
                .concat(returnType.assemble()).concat(SPACE)
                .concat(name)
                .concat(LRB).concat(RRB).concat(LCB).concat(NL)
                .concat(RCB);
    }
}
