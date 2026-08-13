class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vist = new int[n][m];
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        int max = 0;
        for(int l=0;l<n;l++){
            for(int j=0;j<m;j++){

            if(grid[l][j]==1) {
                q.offer(new Pair(l,j));
                vist[l][j] = 1;
            }
             int total = 0;
             while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            total++;
            for(int i=0;i<4;i++){
                int nr = r+row[i];
                int nc = c+col[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vist[nr][nc]==0){
                    
                    q.offer(new Pair(nr,nc));
                    vist[nr][nc] = 1;
                    
                }

            }
             }
              max = Math.max(max,total);
             }
            }
        
        return max;
}}