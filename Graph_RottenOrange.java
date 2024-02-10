import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Main {
    static int rotOrange(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 1; 
                    q.add(new Pair(i, j));
                } else {
                    vis[i][j] = 0; 
                }
            }
        }

        int tm = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Pair curr = q.poll();
                int r = curr.first;
                int c = curr.second;

                for (int i = 0; i < 4; i++) {
                    int nrow = r + drow[i];
                    int ncol = c + dcol[i];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                        q.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = 1;
                    }
                }
            }
            if (!q.isEmpty()) {
                tm++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    return -1; 
                }
            }
        }

        return tm;
    }

    public static void main(String[] args) {
        int v[][] = { { 2, 1, 0, 2, 1 },
                      { 1, 0, 1, 2, 1 },
                      { 1, 0, 0, 2, 1 } };

        System.out.println("Max time incurred: " + rotOrange(v));
    }
}
