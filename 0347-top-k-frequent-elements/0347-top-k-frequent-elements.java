class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums) {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->hm.get(a)-hm.get(b));
        int[] ans = new int[k];
        for(int key:hm.keySet()){
            pq.offer(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}