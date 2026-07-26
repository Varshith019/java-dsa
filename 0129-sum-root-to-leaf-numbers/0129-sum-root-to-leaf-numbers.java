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
    int sum = 0;
    public void fun(TreeNode root,String path){
        if(root==null){
           
            return;
        }
        path+=root.val;
        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(path);
            return;
        }
        fun(root.left,path);
        fun(root.right,path);

    }
    public int sumNumbers(TreeNode root) {
  
        fun(root,"");
        return sum;
    }
}