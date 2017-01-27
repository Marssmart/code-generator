package org.deer.assembly.classes;

import org.junit.Test;

public class StatementsTest extends ClassDataSamples {

    @Test
    public void testConstructor() {
        System.out.println(CONSTRUCTOR.assemble());
    }

    @Test
    public void testClass() {
        System.out.println(PROCESSOR_CLASS.assemble());
    }

    @Test
    public void testMethod() {
        System.out.println(METHOD_STATEMENT.assemble());
    }

    @Test
    public void testAttribute(){
        System.out.println(ATTRIBUTE_ONE.assemble());
        System.out.println(ATTRIBUTE_TWO.assemble());
        System.out.println(ATTRIBUTE_THREE.assemble());
    }
}