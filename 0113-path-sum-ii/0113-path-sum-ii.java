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
    public static void fun(TreeNode root,int target,List<Integer> list,List<List<Integer>> ans){
        if(root==null) {
            return;
        }
        list.add(root.val);
        target = target-root.val;
        //node to leaf path so u can understand clear question statement 
        if(target==0 && root.left==null && root.right==null){
            ans.add(new ArrayList<>(list));
        }
        fun(root.left,target,list,ans);
        fun(root.right,target,list,ans);

        list.remove(list.size()-1);
        
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fun(root,targetSum,list,ans);
        return ans;

    }
}