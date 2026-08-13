class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j));
                    vist[i][j] = 1;
                }
            }
        }
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        int count = 0;
        while(!q.isEmpty()){
           Pair curr = q.poll();
           int r = curr.row;
           int c = curr.col;
           for(int i=0;i<4;i++){
             int nr = r+row[i];
             int nc = c+col[i];
             if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    count++;
              }
              else if(grid[nr][nc]==0){
                count++;
              }
           }
        }
        return count;
    }
}