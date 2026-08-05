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
    int count = 0;
    public void path(TreeNode root,long target){
        if(root==null) return;
        target = target-root.val;
        if(target==0) {
            count+=1;
        }
        path(root.left,target);
        path(root.right,target);
    }
    public void calling(TreeNode root,long target){
        if(root==null) return;
        path(root,target);
        calling(root.left,target);
        calling(root.right,target);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        
        calling(root,(long)targetSum);
        return count;
    }
}