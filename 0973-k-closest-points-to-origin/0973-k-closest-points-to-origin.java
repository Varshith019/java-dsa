class Solution {
    public int dis(int[] arr){
       int x = arr[0];
       int y = arr[1];
       return x*x+y*y;

    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->dis(a)-dis(b));
        for(int i=0;i<n;i++){
           pq.offer(points[i]);
        }
        int[][] ans = new int[k][2];
        int i = 0;
         while(k-->0)
            ans[i++] = pq.poll();
        
        return ans;
    }
}