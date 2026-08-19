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
    Stack<TreeNode> st1 = new Stack<>(); // descending
    Stack<TreeNode> st2 = new Stack<>(); // ascending

    public void in(TreeNode root) {
        while (root != null) {
            st1.push(root);
            root = root.right;
        }
    }

    public void de(TreeNode root) {
        while (root != null) {
            st2.push(root);
            root = root.left;
        }
    }

    public TreeNode nextSmallest() {
        TreeNode curr = st2.pop();
        de(curr.right);       // right subtree, then full left
        return curr;
    }

    public TreeNode nextLargest() {
        TreeNode curr = st1.pop();
        in(curr.left);        // left subtree, then full right
        return curr;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        de(root);
        in(root);

        TreeNode xnode = nextSmallest();
        TreeNode ynode = nextLargest();

        while (xnode != ynode && xnode.val < ynode.val) {
            int sum = xnode.val + ynode.val;

            if (sum == k) {
                return true;
            }

            if (sum > k) {
                if (st1.isEmpty()) return false;
                ynode = nextLargest();
            } else {
                if (st2.isEmpty()) return false;
                xnode = nextSmallest();
            }
        }

        return false;
    }
}