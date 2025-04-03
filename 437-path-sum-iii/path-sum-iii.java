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
    private int TargetSum;
    private Map<Long, Integer> cumulativeSumCount = new HashMap<>();
    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        cumulativeSumCount.put(0L, 1);
        this.targetSum = targetSum;
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        int pathCount = cumulativeSumCount.getOrDefault(currentSum - targetSum, 0);
        cumulativeSumCount.merge(currentSum, 1, Integer::sum);
        pathCount += dfs(node.left, currentSum);
        pathCount += dfs(node.right, currentSum);
        cumulativeSumCount.merge(currentSum, -1, Integer::sum);
        return pathCount;
    }
}