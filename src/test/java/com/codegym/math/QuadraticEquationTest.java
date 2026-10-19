package com.codegym.math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.codegym.math.QuadraticEquation.*;

class QuadraticEquationTest {
    @Test void twoRealRoots() {
        var s = solve(1, -3, 2);
        assertEquals(Kind.TWO, s.kind());
        assertEquals(1, s.roots().get(0), 1e-12);
        assertEquals(2, s.roots().get(1), 1e-12);
    }
    @Test void repeatedRoot() {
        var s = solve(1, -2, 1);
        assertEquals(Kind.ONE, s.kind()); assertEquals(1, s.roots().get(0));
    }
    @Test void noRealRoots() { assertEquals(Kind.NONE, solve(1, 0, 1).kind()); }
    @Test void linearEquation() { assertEquals(-2, solve(0, 2, 4).roots().get(0)); }
    @Test void constantCases() {
        assertEquals(Kind.INFINITE, solve(0, 0, 0).kind());
        assertEquals(Kind.NONE, solve(0, 0, 4).kind());
    }
    @Test void zeroConstant() {
        var s = solve(1, 2, 0); assertEquals(-2, s.roots().get(0)); assertEquals(0, s.roots().get(1), 0);
    }
    @Test void smallRootKeepsPrecision() {
        var s = solve(1, 1e8, 1);
        assertEquals(-1e8, s.roots().get(0), 1e-7);
        assertEquals(-1e-8, s.roots().get(1), 1e-20);
    }
    @Test void largeCoefficientsDoNotOverflowDiscriminant() {
        var s = solve(1e200, -3e200, 2e200);
        assertEquals(Kind.TWO, s.kind()); assertEquals(1, s.roots().get(0), 1e-12); assertEquals(2, s.roots().get(1), 1e-12);
    }
    @Test void nonFiniteCoefficientsRejected() {
        assertThrows(IllegalArgumentException.class, () -> solve(Double.NaN, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> solve(1, Double.POSITIVE_INFINITY, 1));
    }
}
