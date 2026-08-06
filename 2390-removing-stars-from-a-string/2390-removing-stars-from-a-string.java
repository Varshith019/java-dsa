class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(sb.length()>0 && ch=='*'){
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}