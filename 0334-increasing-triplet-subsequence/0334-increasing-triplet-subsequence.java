class Solution {
    public static int upperBound(List<Integer> list,int key){
        int l = 0;
        int r = list.size()-1;
        int ans = list.size();
        while(l<=r){
            int mid = (l+r)/2;
            if(list.get(mid)>=key){
                ans = mid;
                r = mid-1;
                
            }
            else {
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ls.size()==0 || ls.get(ls.size()-1)<nums[i]){
                ls.add(nums[i]);
            }
            else {
                int in = upperBound(ls,nums[i]);
                ls.set(in,nums[i]);
            }
        }
        if(ls.size()>=3) return true;
        else return false;
    }
}