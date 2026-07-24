class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int l = 0;
        for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        hm.put(ch,hm.getOrDefault(ch,0)+1);
        while(hm.get(ch)>1){
            hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
            if(hm.get(s.charAt(l))==0){
              hm.remove(s.charAt(l));
            }
            l++;
        }
        
        max = Math.max(max,i-l+1);
        }
        return max;
    }
}