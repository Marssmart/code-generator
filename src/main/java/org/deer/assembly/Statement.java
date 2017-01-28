package org.deer.assembly;

import static org.deer.assembly.Constants.NL;
import static org.deer.assembly.Constants.NOTHING;
import static org.deer.assembly.Constants.SPACE;

import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.deer.assembly.annotation.Annotation;

public interface Statement {

    String assemble();

    default String block(final String blockContent) {
        if (StringUtils.isEmpty(blockContent)) {
            return "";
        } else {
            return NL.concat(blockContent).concat(NL);
        }
    }

    default String annotationsBlock(final Set<Annotation> annotations) {
        if (annotations == null || annotations.isEmpty()) {
            return NOTHING;
        }

        return annotations.stream().map(Annotation::assemble).collect(Collectors.joining(NL)).concat(NL);
    }

    default String annotationsInline(final Set<Annotation> annotations){
        if (annotations == null || annotations.isEmpty()) {
            return NOTHING;
        }

        return annotations.stream().map(Annotation::assemble).collect(Collectors.joining(SPACE)).concat(SPACE);
    }
}
