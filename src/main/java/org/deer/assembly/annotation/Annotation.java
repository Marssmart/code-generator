package org.deer.assembly.annotation;

import static org.deer.assembly.Constants.COMMASPACE;
import static org.deer.assembly.Constants.LRB;
import static org.deer.assembly.Constants.RRB;

import com.google.common.base.CaseFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.deer.assembly.Statement;
import org.deer.assembly.packages.PackageStatement;

public class Annotation implements Statement {

    private final String name;
    private final PackageStatement packageStatement;
    private final Set<AnnotationAttribute> attributes;

    public Annotation(final String name, final PackageStatement packageStatement) {
        this.name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
        this.packageStatement = packageStatement;
        this.attributes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public PackageStatement getPackageStatement() {
        return packageStatement;
    }

    public Annotation addAttribute(final AnnotationAttribute attribute) {
        this.attributes.add(attribute);
        return this;
    }

    @Override
    public String assemble() {
        if (attributes.isEmpty()){
            return "@".concat(name);
        }else if(attributes.size() == 1){
            return "@".concat(name).concat(LRB).concat(attributes.iterator().next().getValue().toString()).concat(RRB);
        }else{
            return "@".concat(name)
                    .concat(LRB)
                    .concat(attributes.stream().map(AnnotationAttribute::assemble).collect(Collectors.joining(COMMASPACE)))
                    .concat(RRB);
        }
    }
}
