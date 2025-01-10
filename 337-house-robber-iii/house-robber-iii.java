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
    public int rob(TreeNode root) {
        Pair p = dfs(root);
        return Math.max(p.withRoot, p.withoutRoot);
    }

    private Pair dfs(TreeNode root){
        if(root == null) {
            return new Pair(0,0);
        }
        Pair leftPair = dfs(root.left);
        Pair rightPair = dfs(root.right);

        int withRoot = root.val + leftPair.withoutRoot + rightPair.withoutRoot;
        int withoutRoot = Math.max(leftPair.withoutRoot, leftPair.withRoot) + Math.max(rightPair.withoutRoot, rightPair.withRoot);

        return new Pair(withRoot, withoutRoot);
    }

    public class Pair{
        int withRoot;
        int withoutRoot;

        public Pair(int i, int j){
            this.withRoot = i;
            this.withoutRoot = j;
        }
    }
}