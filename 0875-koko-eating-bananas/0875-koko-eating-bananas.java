class Solution {
    public static boolean possible(int[] piles,int mid,int h){
        long sum = 0;
        int n = piles.length;
        for(int i=0;i<n;i++){
            sum+=(int)Math.ceil((double)piles[i] / mid);
        
        }
        if(sum>h) return false;
        else return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,piles[i]);
        }
        int ans = 0;
        int l = 1;
        int r = max;
        while(l<=r){
            int mid = (l+r)/2;
          
            if(possible(piles,mid,h)){
                ans = mid;
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return ans;
    }
}