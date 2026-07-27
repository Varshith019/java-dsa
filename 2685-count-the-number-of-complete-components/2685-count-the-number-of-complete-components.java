class Solution {
   
    public static void dfs(int node,boolean[] vis,List<List<Integer>> list,List<Integer> co){
        vis[node] = true;
        co.add(node);
        for(int it:list.get(node)){
            if(!vis[it]){
            dfs(it,vis,list,co);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int m = edges.length;
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
           if(!vis[i]) {
            List<Integer> co = new ArrayList<>();
            dfs(i,vis,list,co);
            int cosize = co.size();
            boolean is = true;
            for(int node:co){
                if(list.get(node).size()!=cosize-1){
                   is = false;
                   break;
                }
            }
            if(is) count++;
           }
        }
        return count;
    }
}