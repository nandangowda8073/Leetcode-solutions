import java.util.*;

class Solution {

    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> queue = new LinkedList<>();

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            int row = curr.row;
            int col = curr.col;

            for (int k = 0; k < 4; k++) {

                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    dist[newRow][newCol] = dist[row][col] + 1;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
        }

        return dist;
    }
}