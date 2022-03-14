package com.nc.edu.ta.kvasov.pr0.operations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationTest {
    @Test
    public void testMultiply() {
        for (int a = 0; a < 100; a++)
            for (int b = 0; b < 100; b++)
                assertEquals(a * b, new Operation(a, b).getResult());
    }
}