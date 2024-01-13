import java.util.*;
class Main{
    static void floodFill(char[][] grid,int i,int j,char target,char replacementChar){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!= target){
            return;
        }
        grid[i][j]=replacementChar;
        floodFill(grid,i-1,j,target,replacementChar);
        floodFill(grid,i+1,j,target,replacementChar);
        floodFill(grid,i,j-1,target,replacementChar);
        floodFill(grid,i,j+1,target,replacementChar);
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        int rowToFill = 2;
        int colToFill = 2;
        char replacementChar = '2';
        char targetChar = grid[rowToFill][colToFill];
        floodFill(grid, rowToFill, colToFill, targetChar, replacementChar);
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
