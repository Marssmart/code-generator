package org.deer.assembly.packages;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

public class PackageStatement {

    private final Set<String> elements;
    private final String name;

    public PackageStatement(final String name) {
        elements = Arrays.stream(StringUtils.split(name, ".")).collect(toSet());
        this.name = name;
    }

    public Set<String> getElements() {
        return elements;
    }

    public String getName() {
        return name;
    }
}
