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
    static boolean is = true;
    public static int bal(TreeNode root){
        if(root==null) return 0;
       int lh = bal(root.left);
       int  rh = bal(root.right);
        if(Math.abs(lh-rh)>1) {
             is = false;
        }
         return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        is = true;
         bal(root);
         return is;
    
    }
}