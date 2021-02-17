package com.epam.task;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SolvingSQRTandReturnAsNumberTest {
    private static SolvingSQRTandReturnAsNumber solvingSQRTandReturnAsNumber;

    @BeforeAll
    static void init() {
        solvingSQRTandReturnAsNumber = new SolvingSQRTandReturnAsNumber();
    }

    @After
    public void afterAll() {
        solvingSQRTandReturnAsNumber = null;
    }

    @Test
    public void solvingSQRTandReturnAsNumberTest() {
        assertEquals(Double.parseDouble(solvingSQRTandReturnAsNumber.solvingSQRTandReturnAsNumber("sqrt4")),2, 0.01);
    }
}
