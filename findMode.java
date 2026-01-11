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
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> counts = new HashMap<>();
        int[] maxVal = {0};
        List<Integer> mode = new ArrayList<>();

        inorder(root,counts,maxVal,mode);

        int[] res = new int[mode.size()];
        for(int i = 0;i<mode.size();i++){
            res[i] = mode.get(i);
        }
        return res;
    }
    private void inorder(TreeNode node,Map<Integer,Integer> counts, int[] maxVal, List<Integer> mode){
        if(node == null){
            return;
        }
        inorder(node.left,counts,maxVal,mode);
        
        int count = counts.getOrDefault(node.val,0)+1;
        counts.put(node.val,count);
        if(count > maxVal[0]){
            maxVal[0] = count;
            mode.clear();
            mode.add(node.val);
        }else if(count == maxVal[0]){
            mode.add(node.val);
        }
        inorder(node.right,counts,maxVal,mode);
    }
}
