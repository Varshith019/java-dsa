class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
         pq.offer(gifts[i]);
        }
        while(!pq.isEmpty() && k-->0){
            int max = pq.poll();
            pq.offer((int) Math.sqrt(max));
        }
        long sum = 0;
        while(pq.size()>0){
            sum+=(long)pq.poll();
        }
        return sum;
    }
}