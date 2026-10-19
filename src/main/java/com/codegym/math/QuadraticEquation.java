package com.codegym.math;

import java.util.List;

/** Real solutions of ax² + bx + c = 0, including a = 0. */
public final class QuadraticEquation {
    private QuadraticEquation() {}
    public enum Kind { NONE, ONE, TWO, INFINITE }
    public record Solution(Kind kind, List<Double> roots) {
        public Solution { roots = List.copyOf(roots); }
    }
    public static Solution solve(double a, double b, double c) {
        if (!Double.isFinite(a) || !Double.isFinite(b) || !Double.isFinite(c))
            throw new IllegalArgumentException("Coefficients must be finite");
        if (a == 0) {
            if (b != 0) return new Solution(Kind.ONE, List.of(-c / b));
            return new Solution(c == 0 ? Kind.INFINITE : Kind.NONE, List.of());
        }
        double scale = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
        double aa = a / scale, bb = b / scale, cc = c / scale;
        double delta = Math.fma(bb, bb, -4 * aa * cc);
        if (delta < 0) return new Solution(Kind.NONE, List.of());
        if (delta == 0) return new Solution(Kind.ONE, List.of(-bb / (2 * aa)));
        // The q formulation avoids cancellation for a small root when |b| is large.
        double q = -0.5 * (bb + Math.copySign(Math.sqrt(delta), bb));
        double x1 = q / aa, x2 = cc / q;
        return new Solution(Kind.TWO, List.of(Math.min(x1, x2), Math.max(x1, x2)));
    }
}
