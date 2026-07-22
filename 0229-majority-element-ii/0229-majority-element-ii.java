class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int c1 = 0;
        int c2 = 0;
        int e1 = 0;
        int e2 = 0;
        for(int i=0;i<nums.length;i++){
            if(c1==0 && nums[i]!=e2){
                e1 = nums[i];
                c1=1;
            }
            else if(c2==0 && nums[i]!=e1){
                e2 = nums[i];
                c2 = 1;
            }
            else if(e1==nums[i]){
                c1++;
            }
            else if(e2==nums[i]){
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<n;i++){
            if(e1==nums[i]) count1++;
            if(e2==nums[i]) count2++;
        }
        List<Integer> list = new ArrayList<>();
        if(count1>n/3 && count2>n/3 && e1!=e2){
            list.add(e1);
            list.add(e2);
        }
        else if(count1>n/3 && count2<=n/3){
             list.add(e1);
        } 
        else if(count2>n/3){
            list.add(e2);
        }
        return list;
    }
        
}