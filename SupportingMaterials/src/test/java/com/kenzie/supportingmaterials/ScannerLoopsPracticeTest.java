package com.kenzie.supportingmaterials;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScannerLoopsPracticeTest {

    @Test
    public void readsTenThings() {
    }

    // Does the program run?
    // This should pass automatically

    @Test
    public void runMain() {
        boolean crashed = false;
        try {
            Application.main(new String[]{});
        } catch (Exception e) {
            crashed = true;
        }

        assertEquals(false, crashed, "App can run without crashing") ;
    }
}
