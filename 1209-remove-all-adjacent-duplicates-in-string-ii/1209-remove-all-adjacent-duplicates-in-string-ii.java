
class Pair {
    char ele;
    int fre;
    Pair(char ele, int fre) {
        this.ele = ele;
        this.fre = fre;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek().ele == ch) {
                st.peek().fre += 1;
                if (st.peek().fre == k) {
                    st.pop();
                }
            } else {
                st.push(new Pair(ch, 1));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Pair pair : st) {
            for (int i = 0;i <pair.fre; i++) {
                ans.append(pair.ele);
            }
        }
        return ans.toString();
    }
}