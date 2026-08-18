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
    int idx = 0;
    public  TreeNode create(int[] nums,int lower,int upper){
        if(idx==nums.length) return null;
        int val = nums[idx];
        if(val<=lower || val>=upper) {
            return null;
        }
        TreeNode root = new TreeNode(nums[idx++]);
        root.left = create(nums,lower,root.val);
        root.right = create(nums,root.val,upper);
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return create(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}