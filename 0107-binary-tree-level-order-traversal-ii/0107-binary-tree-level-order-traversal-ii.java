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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {        
        List<List<Integer>> finalAns = new ArrayList<>();
        if(root == null) return finalAns;
        Stack<List<Integer>> ans = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();            
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){                
            TreeNode node = q.remove();
            temp.add(node.val);
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
            }
            ans.push(temp);
        }
        //List<Integer> temp = new ArrayList<>();
        while(!ans.isEmpty()){
            finalAns.add(ans.pop());
        }
        return finalAns;
    }
}