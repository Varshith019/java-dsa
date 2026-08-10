class Solution {
    public String frequencySort(String s) {
       int n = s.length();
       HashMap<Character,Integer> hm = new HashMap<>();
       for(int i=0;i<n;i++){
          char ch = s.charAt(i);
          hm.put(ch,hm.getOrDefault(ch,0)+1);
       }
       PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->(hm.get(b))-(hm.get(a)));
       for(char key:hm.keySet()){
          pq.offer(key);
       }
       StringBuilder sb = new StringBuilder();
       while(!pq.isEmpty()){
          char ch = pq.poll();
          int fre = hm.get(ch);
          for(int i=0;i<fre;i++){
            sb.append(ch);
          }
       }
        return sb.toString();
    }
}