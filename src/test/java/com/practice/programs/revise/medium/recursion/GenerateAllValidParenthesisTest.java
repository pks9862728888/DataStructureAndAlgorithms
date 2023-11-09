package com.practice.programs.revise.medium.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test that GenerateAllValidParenthesis class works")
class GenerateAllValidParenthesisTest {

    private static GenerateAllValidParenthesis obj;

    @BeforeAll
    static void init() {
        log.info("@BeforeAll called...");
        obj = new GenerateAllValidParenthesis();
    }

    @Test
    @Tag("balancedParenthesis2")
    void balancedBracesInputTwo() {
        log.info("Executing balancedBraces test with two input...");
        List<String> braces = obj.balancedBraces(2);
        Assertions.assertNotNull(braces);
        Assertions.assertEquals(2, braces.size(), () ->"Only 2 combinations are possible");
        Assertions.assertEquals(Arrays.asList("(())", "()()"), braces);
    }

    @Test
    void balancedBracesInputThree() {
        log.info("Executing balancedBraces test with three input...");
        List<String> braces = obj.balancedBraces(3);
        Assertions.assertEquals(5, braces.size(), () -> "Only 5 combinations are possible, but was: " + braces);
    }
}