package com.nc.edu.ta.kvasov.pr0.operations;
public class Operation {
    /**
     * Create new operation using two numbers.
     *
     * @param x first operand
     * @param y second operand
     */
    public Operation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @return result of operation
     */
    public int getResult() {
        return x * y;
    }
    private int x;
    private int y;
}
