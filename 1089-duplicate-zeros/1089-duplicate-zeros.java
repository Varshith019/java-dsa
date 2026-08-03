class Solution {
    public void duplicateZeros(int[] arr) {
       int n = arr.length;
       int zero = 0;
       for(int num:arr) {
        if(num==0) zero++;
       }
       for(int i=n-1;i>=0;i--){
        if(i+zero<n){
            arr[i+zero] = arr[i];
        }
        if(arr[i]==0){
            zero--;
            if(i+zero<n){
                arr[i+zero] = 0;
            }
        }
       }

    }
}