class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int[] ans = new int[k];
        int ind = 0;
        while (k-->0) {
            int max = 0;
            int value = 0;
            for (int key :hm.keySet()) {
                if(max<hm.get(key)){
                   max = hm.get(key);
                   value = key;
                }
            }
            hm.remove(value);
            ans[ind++] = value;
        }
        return ans;
    }
}