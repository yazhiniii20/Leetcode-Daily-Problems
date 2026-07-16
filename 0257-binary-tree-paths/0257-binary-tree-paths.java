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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        StringBuilder sb = new StringBuilder();
        paths(root,sb,ans);
        return ans;
    }
    static void paths(TreeNode root,StringBuilder path,List<String> ans){
        int len = path.length();

        if(root == null){
            return;
        }
        path.append(root.val);
        
        if(root.left == null && root.right == null){
            ans.add(path.toString());
        }else{ 
            path.append("->");          
            paths(root.left,path,ans);
            paths(root.right,path,ans);
        }
        path.setLength(len);
    }
}