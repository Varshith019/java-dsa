class Solution {
    
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxf = 0;
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int l = 0;
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            maxf = Math.max(maxf,hm.get(ch));
            while((r-l+1)-maxf>k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                if(hm.get(s.charAt(l))==0) {
                    hm.remove(s.charAt(l));
                }
                
                l++;
            }
            if((r-l+1)-maxf<=k)
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}