import java.util.*;
class Main{
    static void bfs(int row,int col,char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row,col});
        grid[row][col]='0';// flag 0 visited element
        int[][] directions={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };//helps to search all 8 direction 
        while(!q.isEmpty()){
            int[] current=q.poll();
            for(int[] dir:directions){
                int nrow=current[0]+dir[0];
                int ncol=current[1]+dir[1];
                if(nrow>=0 && ncol>=0 &&nrow<n&&ncol<m&&grid[nrow][ncol]=='1'){
                    q.offer(new int[]{nrow,ncol});
                    grid[nrow][ncol]='0';
                }
            }
        }
    }
    static int numIslands(char[][] grid){
        // this loops typically used to iterate through all island if island ==1 then perform bfs 
        int n=grid.length;
        int m=grid[0].length;
        if(grid==null||n==0||m==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(i,j,grid);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println("Number of islands: " + numIslands(grid));
    }
}
