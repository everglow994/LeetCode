package Coding;

public class OverlapRectangle {

    // leetcode version 223 rectangle area
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int twoArea = (C - A) * (D - B) + (G - E) * (H - F);
        boolean isOverlap = (Math.min(G, C) > Math.max(E, A)) && (Math.min(H, D) > Math.max(F, B));
        if(!isOverlap) {
            return twoArea;
        }
        int width = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        return twoArea - width * height;
    }



    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

        return !(l1.x >= r2.x) ||
                (r1.x <= l2.x) ||
                (l1.y <= r2.y) ||
                (r1.y >= l2.y);
    }
}
