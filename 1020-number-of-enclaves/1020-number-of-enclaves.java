class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int[][] arr,int[][] vist,Queue<Pair> q){
        int n = arr.length;
        int m = arr[0].length;
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            for(int i=0;i<4;i++){
                int nr = r+row[i];
                int nc = c+col[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && arr[nr][nc]==1 && vist[nr][nc]==0){
                    q.offer(new Pair(nr,nc));
                    vist[nr][nc] = 1;
                }
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
 
for(int i = 0; i < n; i++){

    if(grid[i][0] == 1 && vist[i][0] == 0){
        vist[i][0] = 1;
        q.offer(new Pair(i,0));
        bfs(grid,vist,q);
    }

    if(grid[i][m-1] == 1 && vist[i][m-1] == 0){
        vist[i][m-1] = 1;
        q.offer(new Pair(i,m-1));
        bfs(grid,vist,q);
    }
}


for(int j = 0; j < m; j++){

    if(grid[0][j] == 1 && vist[0][j] == 0){
        vist[0][j] = 1;
        q.offer(new Pair(0,j));
        bfs(grid,vist,q);
    }

    if(grid[n-1][j] == 1 && vist[n-1][j] == 0){
        vist[n-1][j] = 1;
        q.offer(new Pair(n-1,j));
        bfs(grid,vist,q);
    }
}
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vist[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}