package DFS;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // 1. write permutation of 2d matrix
    // 2. validate a search results of n queen solution
    // 3. print the result


    // 可以粗略说 time O(N! * N)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }

    private void search(int n,
            List<Integer> cols,
            List<List<String>> result) {

        if(cols.size() == n) {
            result.add(print(cols));
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            search(n, cols, result);
            cols.remove(cols.size() - 1);
        }

    }


    private List<String> print(List<Integer> cols) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }

    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();

        for(int i = 0; i < row; i++) {

            if(cols.get(i) == column) {
                return false;
            }

            if(i + cols.get(i) == row + column) {
                return false;
            }

            if(i - cols.get(i) == row - column) {
                return false;
            }
        }

        return true;
    }


}
