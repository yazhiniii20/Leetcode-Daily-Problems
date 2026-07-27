/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static void markParents(TreeNode root,HashMap<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
                parent.put(curr.left,curr);
            }
            if(curr.right != null){
                q.offer(curr.right);
                parent.put(curr.right,curr);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        markParents(root,parent);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int distance = 0;
        while(!q.isEmpty()){
            int n = q.size();
            if(distance == k) break;
            distance++;
            for(int i=0;i<n;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr) != null && visited.get(parent.get(curr)) == null){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            } 
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node.val);
        }
        return ans;
    }
}