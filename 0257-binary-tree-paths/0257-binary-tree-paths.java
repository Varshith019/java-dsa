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
    public static void fun(TreeNode root,String path,List<String> list){
        if(root==null) return;
        if(path.length()==0){
            path = String.valueOf(root.val);
        }
        else {
            path=path+"->"+root.val;
        }
        if(root.left==null && root.right==null){
            list.add(path);
            return;
        }
        fun(root.left,path,list);
        fun(root.right,path,list);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        fun(root,"",list);
        return list;
    }
}