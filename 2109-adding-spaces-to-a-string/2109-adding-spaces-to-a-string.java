class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int curr = 0;
        int count = 0;
        for(int i=0;i<n;i++){
         char ch = s.charAt(i);
         if(curr<spaces.length && i==spaces[curr]){
            sb.append(" ");
            curr++;
         }
         sb.append(ch);
         
        }
        return sb.toString();
    }
}