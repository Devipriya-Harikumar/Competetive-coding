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
    List<Integer> result = new LinkedList<>();
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    private TreeNode flattenTree(TreeNode node){
        if(node == null){
            return null;
        }

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        if(node.left != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        if(rightTail != null){
            return rightTail;
        }
        if(leftTail != null){
            return leftTail;
        }
        return node;
    }
}