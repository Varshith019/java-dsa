class Solution {
    public static boolean palin(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String str : words){
            if(palin(str)){
                return str;
            }
        }
        return "";
    }
}