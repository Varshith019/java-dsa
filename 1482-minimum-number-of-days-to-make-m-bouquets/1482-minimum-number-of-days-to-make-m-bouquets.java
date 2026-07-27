class Solution {
    public static boolean possible(int[] arr,int mid,int m,int k){
        int count = 0;
        int n = arr.length;
        int ms = 0;
        for(int i=0;i<n;i++){
            if(mid>=arr[i]) {
                count++;
            if(count==k){

             ms++; 
             count = 0;
            }
            }
            else {
                count = 0;
            }
        }
        if(ms<m) return false;
        return true;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int max = 0;
        int ans = -1;
        for(int i=0;i<n;i++) max = Math.max(max,bloomDay[i]);
        int l = 1;
        int r = max;
        while(l<=r){
        int mid = (l+r)/2;
        if(possible(bloomDay,mid,m,k)){
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