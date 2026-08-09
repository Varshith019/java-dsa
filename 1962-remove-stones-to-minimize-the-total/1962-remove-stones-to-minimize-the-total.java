class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<piles.length;i++) pq.offer(piles[i]);

        while(!pq.isEmpty() && k-->0){
            int max = pq.poll();
            pq.offer(max - (max / 2));
        }
        int sum = 0;
        while(pq.size()>0) {
            sum+=pq.poll();
        }

        return sum;
    }
    
}