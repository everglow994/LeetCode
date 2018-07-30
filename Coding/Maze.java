package Coding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Maze {


    class Coor {
        int x, y;
        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maze(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        if(matrix[0][0] == 9) {
            return 1;
        }
        if(matrix[0][0] == 0) {
            return 0;
        }

        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};

        Queue<Coor> queue = new LinkedList<>();
        Set<Coor> visited = new HashSet<>();
        Coor start = new Coor(0, 0);
        queue.offer(start);
        matrix[0][0] = 0;

        while(!queue.isEmpty()) {
            Coor coor = queue.poll();
            for(int i = 0; i < 4; i++) {
                Coor adj = new Coor(coor.x + dirX[i],
                                        coor.y + dirY[i]);
                if(!inBound(adj, matrix)) {
                    continue;
                }
                if(matrix[adj.x][adj.y] == 9) {
                    return 1;
                }
                if(matrix[adj.x][adj.y] == 1) {
                    queue.offer(adj);
                    matrix[adj.x][adj.y] = 0;
                }
            }
        }

        return 0;
    }

    private boolean inBound(Coor coor, int[][] matrix) {
        int coorX = coor.x;
        int coorY = coor.y;
        int M = matrix.length;
        int N = matrix[0].length;
        return !(coorX < 0 || coorX >= M || coorY < 0 || coorY >= N);
    }
}
