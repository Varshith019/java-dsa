class Pair{
    String str;
    int t;
    Pair(String str,int t){
        this.str = str;
        this.t = t;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String str = curr.str;
            int level = curr.t;
            if(str.equals(endWord)) return level;
            
            for(int i=0;i<str.length();i++){
                char[] word = str.toCharArray();
                for(char ch='a';ch<='z';ch++){
                     word[i]  = ch;
                     String s = new String(word);
                     if(hs.contains(s)){
                        hs.remove(s);
                        q.offer(new Pair(s,level+1));
                     }
                }

            }
        }
        return 0;
    }
}