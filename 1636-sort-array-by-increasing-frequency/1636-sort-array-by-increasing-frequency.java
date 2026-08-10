class Solution {
   
    public int[] frequencySort(int[] nums) {
      int n = nums.length;
      HashMap<Integer,Integer> hm = new HashMap<>();
      for(int num:nums){
        hm.put(num,hm.getOrDefault(num,0)+1);
      }  
      //remameber the this logic 
      PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> {
                int freqA = hm.get(a);
                int freqB = hm.get(b);

                if (freqA == freqB) {
                    return b - a;
                }

                return freqA - freqB;
            });
      int[] ans = new int[n];
      int l = 0;
      for(int key:hm.keySet()){
        pq.offer(key);
      }
        while(!pq.isEmpty()){
            int key = pq.poll();
        int fre = hm.get(key);
        for(int i=0;i<fre;i++){
            ans[l++] = key;
        }

      }
      return ans;
    }
}