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
 // iterative solution 

class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ls = new ArrayList<>();
    if(root==null) {
        
        return ls;
    }
    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    while(!q.isEmpty()){
        TreeNode last = null;
        int len = q.size();
        for(int i=0;i<len;i++){
            TreeNode curr = q.poll();
            last = curr;
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
        }
        ls.add(last.val);
    }
        return ls;
    }
}