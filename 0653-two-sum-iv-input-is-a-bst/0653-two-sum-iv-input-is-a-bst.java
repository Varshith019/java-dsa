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
    HashSet<Integer> hs = new HashSet<>();
    public boolean check(TreeNode root,int k){
        if(root==null) return false;
        int val = k-root.val;
        if(hs.contains(val)) {
            return true;
        }
        hs.add(root.val);
        Boolean left = check(root.left,k);
        Boolean right = check(root.right,k);
        if(left||right) return true;

        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
       return check(root,k);
    }
}