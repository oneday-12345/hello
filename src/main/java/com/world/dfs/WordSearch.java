package com.world.dfs;

public class WordSearch {
    boolean wordSearch(char[][] grid, String word, int i, int j, int index){
        int m=grid.length;
        int n=grid[0].length;
    
        if(index>=word.length()){
            return true;
        }
    
        if(i<0 || i>=m || j<0 ||j>=n){
            return false;
        }
    
        if(grid[i][j]!=word.charAt(index)){
            return false;
        }
    
        char t = grid[i][j];
        grid[i][j]='#';
    
        boolean result =   wordSearch(grid, word, i-1, j, index+1)
                        || wordSearch(grid, word, i+1, j, index+1)
                        || wordSearch(grid, word, i, j-1, index+1)
                        || wordSearch(grid, word, i, j+1, index+1);
    
        grid[i][j] = t;

        return result;
    }
}
