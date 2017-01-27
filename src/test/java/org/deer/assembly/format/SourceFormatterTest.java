package org.deer.assembly.format;

import org.deer.assembly.classes.ClassDataSamples;
import org.junit.Test;

public class SourceFormatterTest implements SourceFormatter{

    @Test
    public void formatSource() throws Exception {
        System.out.println(formatSource(ClassDataSamples.PROCESSOR_CLASS.assemble()));
    }

}