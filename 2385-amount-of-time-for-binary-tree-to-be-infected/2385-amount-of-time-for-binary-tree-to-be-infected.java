/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode target = null;
    public void markparent(HashMap<TreeNode,TreeNode> hm,TreeNode root,Queue<TreeNode> qp){
        hm.put(root,null);
        qp.offer(root);
        while(!qp.isEmpty()){
            TreeNode curr = qp.poll();
            if(curr.left!=null){
                hm.put(curr.left,curr);
                qp.offer(curr.left);
            }
            if(curr.right!=null){
                hm.put(curr.right,curr);
                qp.offer(curr.right);
            }
        }
        
    }
    public void check(TreeNode root,int start){
        if(root==null||target!=null) return;
        if(root.val==start) {
            target = root;
            return;
        }
        check(root.left,start);
        check(root.right,start);
    }
    public int amountOfTime(TreeNode root, int start) {
         if(root==null) return 0;
          HashMap<TreeNode,TreeNode> hm = new HashMap<>();
          Queue<TreeNode> qp = new LinkedList<>();
          markparent(hm,root,qp);

          HashSet<TreeNode> hs = new HashSet<>();
          Queue<TreeNode> q = new LinkedList<>();
          check(root,start);
          q.offer(target);
          hs.add(target);
          int level = 0;
          while(!q.isEmpty()){
             int len = q.size();
             for(int i=0;i<len;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && !hs.contains(curr.left)){
                    hs.add(curr.left);
                    q.offer(curr.left);
                }
                if(curr.right!=null && !hs.contains(curr.right)){
                    hs.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode parent = hm.get(curr);
                if(parent!=null && !hs.contains(parent)){
                    hs.add(parent);
                    q.offer(parent);
                }
                
             }
             level++;
          }
          return level-1;
    }
}