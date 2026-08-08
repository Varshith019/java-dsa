class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = stones.length;
        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int max1 = pq.poll();
            int max2 = pq.poll();
            if(max1!=max2) {
            max1 = max1-max2;
            pq.offer(max1);
            }
        }
        if(pq.size()==1) return pq.poll();
        else return 0;

    }
}