class Pair {
     int row;
     int col;
     Pair(int row,int col){
        this.row = row;
        this.col = col;
     }
}
class Solution {
    private void dfs(int r,int c,char[][] grid,int[][] vist){
        vist[r][c] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = r+row[i];
            int nc = c+col[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && vist[nr][nc]==0){
                dfs(nr,nc,grid,vist);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vist = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vist[i][j]==0){
                    dfs(i,j,grid,vist);
                    count= count+1;

                }
            }
        }
        return count;
    }
}