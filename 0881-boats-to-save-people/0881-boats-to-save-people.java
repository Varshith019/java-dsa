class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int boats = 0;
        int l = 0;
        int r = n-1;
        while(l<=r){
            if(people[l]+people[r]>limit){
                r--;
            }
            else {
                l++;
                r--;
            }
            boats++;
        }
        return boats;
    }
}