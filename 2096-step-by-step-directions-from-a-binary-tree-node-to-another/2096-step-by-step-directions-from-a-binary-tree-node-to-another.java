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

    public boolean getPath(TreeNode root, int target, StringBuilder sb) {
        if (root == null) return false;

        if (root.val == target) return true;

        sb.append('L');
        if (getPath(root.left, target, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        if (getPath(root.right, target, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        getPath(root, startValue, sb1);
        getPath(root, destValue, sb2);

        int i = 0;

        while (i < sb1.length()
                && i < sb2.length()
                && sb1.charAt(i) == sb2.charAt(i)) {
            i++;
        }

        StringBuilder ans = new StringBuilder();

        for (int j = i; j < sb1.length(); j++) {
            ans.append('U');
        }

        for (int j = i; j < sb2.length(); j++) {
            ans.append(sb2.charAt(j));
        }

        return ans.toString();
    }
}
