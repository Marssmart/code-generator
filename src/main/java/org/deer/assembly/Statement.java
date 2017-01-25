package org.deer.assembly;

import static org.deer.assembly.Constants.NL2;

import org.apache.commons.lang.StringUtils;

public interface Statement {

    String assemble();

    default String block(final String blockContent) {
        if (StringUtils.isEmpty(blockContent)) {
            return "";
        } else {
            return NL2.concat(blockContent).concat(NL2);
        }
    }
}
