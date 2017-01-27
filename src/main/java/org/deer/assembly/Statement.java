package org.deer.assembly;

import static org.deer.assembly.Constants.NL;

import org.apache.commons.lang.StringUtils;

public interface Statement {

    String assemble();

    default String block(final String blockContent) {
        if (StringUtils.isEmpty(blockContent)) {
            return "";
        } else {
            return NL.concat(blockContent).concat(NL);
        }
    }
}
