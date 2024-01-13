import java.util.*;
class Main{
    static void dfs(int i,int j,char[][]grid){
        int n=grid.length;
        int m=grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
            return;
        }

        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
    static int numIslands(char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(grid==null || n<0 ||m<0){
            return 0;
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        System.out.println("Number of islands: " + numIslands(grid));
    }
}
