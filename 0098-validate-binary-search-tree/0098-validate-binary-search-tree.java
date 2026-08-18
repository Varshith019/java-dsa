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
    private boolean check(TreeNode root,long lower,long upper){
        if(root==null) return true;
        if(root.val<=lower || root.val>=upper) return false;
        boolean left = check(root.left,lower,root.val);
        boolean right = check(root.right,root.val,upper);
        if(!left || !right) return false;

        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}