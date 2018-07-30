package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FloodFill {


    // 1. BFS
    private class Coordinate {
        int x, y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        int val = image[sr][sc];

        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate center = new Coordinate(sr, sc);
        queue.offer(center);
        while(!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for(int i = 0; i < directionX.length; i++) {
                Coordinate adj = new Coordinate(
                        coor.x + directionX[i],
                        coor.y + directionY[i]
                );
                if(!inBound(adj, image) || image[adj.x][adj.y] != val) {
                   continue;
                }
                queue.offer(adj);
            }
            image[coor.x][coor.y] = newColor;
        }

        return image;
    }

    private boolean inBound(Coordinate coor, int[][] grid) {
        int xbound = grid.length;
        int ybound = grid[0].length;
        if(coor.x < 0 || coor.x >= xbound || coor.y < 0 || coor.y >= ybound) {
            return false;
        }
        return true;
    }


    // 2. DFS
    public int[][] floodFillII(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        if(original == newColor) {
            return image;
        }
        helper(image, original, sr, sc, newColor);
        return image;
    }

    private void helper(int[][] image,
                        int original,
                        int row,
                        int column,
                        int newColor) {
        if(image[row][column] == original) {
            image[row][column] = newColor;
            if(row + 1 < image.length) helper(image, original, row + 1, column, newColor);
            if(column + 1 < image[0].length) helper(image, original, row, column + 1, newColor);
            if(row - 1 >= 0) helper(image, original, row - 1, column, newColor);
            if(column - 1 >= 0) helper(image, original, row, column - 1, newColor);
        }

    }
}


