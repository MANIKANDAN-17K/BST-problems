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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();    
        List<TreeNode>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        for(int node = 1;node <= n;node++){
            dp[node] = new ArrayList<>();
            for(int root = 1;root<= node;root++){
                for(TreeNode left : dp[root - 1]){
                    for(TreeNode right : dp[node - root]){
                        TreeNode res = new TreeNode(root);
                        res.left = left;
                        res.right = clone(right,root);
                        dp[node].add(res);
                    }
                }
            }
        }
        return dp[n];
    }
    public TreeNode clone(TreeNode root,int offset){
        if(root == null) return null;
        TreeNode ans = new TreeNode(root.val + offset);
        ans.left = clone(root.left,offset);
        ans.right = clone(root.right,offset);
        return ans;
    }
}
