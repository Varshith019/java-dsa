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
    boolean is = false;
    public void  path(TreeNode root,int targetsum){
        if(root==null) {
            return;
        }
        targetsum -=root.val;
       if(root.right==null && root.left==null && targetsum==0) {
        is = true;
       }
       path(root.left,targetsum);
       path(root.right,targetsum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) {
            return false;

        }
         path(root,targetSum);
         return is;
    }
}