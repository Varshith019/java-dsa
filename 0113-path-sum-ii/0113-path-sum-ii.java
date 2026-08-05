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
    public boolean isleaf(TreeNode root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    public void path(TreeNode root,int targetsum,List<List<Integer>> ans,List<Integer> list){
        if(root==null) return;
        targetsum = targetsum-root.val;
        list.add(root.val);
        if(isleaf(root) && targetsum==0){
            ans.add(new ArrayList<>(list));
        }
        path(root.left,targetsum,ans,list);
        path(root.right,targetsum,ans,list);
        list.remove(list.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();
      path(root,targetSum,ans,temp); 
      return ans;
    }
}