class Solution {
    public int arrangeCoins(int n) {
        if(n==0||n==1) return n;
        int l = 0;
        int r = n-1;
        while(l<=r){
            long mid = l+(r-l)/2;
            long curr = (mid*(mid+1))/2;
            if(curr==n) return (int)mid;
            else if(curr>n) r =(int)mid-1;
            else l = (int)mid+1;
        }
        return r;
    }
}