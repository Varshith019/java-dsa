class Pair {
    int row;
    int col;
    int dis;
    Pair(int row,int col,int dis){
        this.row = row;
        this.col = col;
        this.dis =dis;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vist = new int[n][m];
        int[][] dis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vist[i][j] = 1;
                }
            }
        }
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        while(!q.isEmpty()){
          Pair curr = q.poll();
          int r = curr.row;
          int c = curr.col;
          int d = curr.dis;
          dis[r][c] = d;
          for(int i=0;i<4;i++){
            int nr = r+row[i];
            int nc = c+col[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==1 && vist[nr][nc]==0){
                q.offer(new Pair(nr,nc,d+1));
                vist[nr][nc] = 1;
            }
          }

        }
        return dis;
    }
}