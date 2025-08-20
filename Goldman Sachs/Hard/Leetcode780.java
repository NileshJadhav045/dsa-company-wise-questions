
public class Leetcode780 {
    /* Leetcode -> 780. Reaching Points
     * Given four integers sx, sy, tx, and ty, return true if it is possible to
     * convert the point (sx, sy) to the point (tx, ty) through some operations, or
     * false otherwise.
     * 
     * The allowed operation on some point (x, y) is to convert it to either (x, x +
     * y) or (x + y, y).
     */
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // Keep reducing the target (tx, ty) backwards until it is no longer larger than
        // (sx, sy)
        // We move backwards because going forward (sx, sy → tx, ty) would have
        // exponential branching
        // But backwards, the moves are deterministic.
        while (sx < tx && sy < ty) {
            if (tx < ty) {
                // If ty is larger, reduce ty using modulo (reverse of adding tx repeatedly)
                ty %= tx;
            } else {
                // If tx is larger, reduce tx using modulo (reverse of adding ty repeatedly)
                tx %= ty;
            }
        }

        // Final check:
        // Case 1: If x coordinates match (sx == tx),
        // then y must be reachable by repeatedly adding multiples of sx.
        // That means (ty - sy) must be divisible by sx.
        // Also, sy <= ty since we can only increase coordinates.
        //
        // Case 2: If y coordinates match (sy == ty),
        // then x must be reachable by repeatedly adding multiples of sy.
        // That means (tx - sx) must be divisible by sy.
        // Also, sx <= tx since we can only increase coordinates.
        return (sx == tx && sy <= ty && (ty - sy) % sx == 0) ||
                (sy == ty && sx <= tx && (tx - sx) % sy == 0);
    }

    public static void main(String[] args) {
        int sx = 1, sy = 1, tx = 3, ty = 5;
        System.out.println(reachingPoints(sx, sy, tx, ty));
    }
}
