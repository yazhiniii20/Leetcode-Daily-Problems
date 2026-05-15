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
    public boolean isBalanced(TreeNode root) {
        int ans = check(root);
        return (ans == -1)?false:true;
    }
    static int check(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftTree =  check(root.left);
        int rightTree = check(root.right);
        if(leftTree == -1 || rightTree == -1){
            return -1;
        }
        if(Math.abs(leftTree-rightTree) > 1){
            return -1;
        }
        return Math.max(leftTree,rightTree)+1;
    }
}