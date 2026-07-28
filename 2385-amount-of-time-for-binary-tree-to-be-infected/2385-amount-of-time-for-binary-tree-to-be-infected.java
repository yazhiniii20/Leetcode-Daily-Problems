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
    static TreeNode mapParents(HashMap<TreeNode,TreeNode> parent,TreeNode root,int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        parent.put(root,null);
        TreeNode target = null;
        while(!q.isEmpty()){
          TreeNode node = q.poll();
          if (node.val == start) target = node;
          if(node.left != null){
            parent.put(node.left,node);
            q.offer(node.left);
          }
          if(node.right != null){
            parent.put(node.right,node);
            q.offer(node.right);
          }
        }
        return target;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        TreeNode target = mapParents(parent,root,start);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        int time = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        while(!q.isEmpty()){
            int n = q.size();
            int flag = 0;
            for(int i=0;i<n;i++){                
                TreeNode node = q.poll();
                if(node.left != null && visited.get(node.left) == null){
                    flag = 1;
                    q.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right != null && visited.get(node.right) == null){
                    flag = 1;
                    q.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parent.get(node) != null && visited.get(parent.get(node)) == null){
                    flag = 1;
                    q.offer(parent.get(node));
                    visited.put(parent.get(node),true);
                }
            }
            if(flag == 1) time++;
        }
        return time;
    }
}