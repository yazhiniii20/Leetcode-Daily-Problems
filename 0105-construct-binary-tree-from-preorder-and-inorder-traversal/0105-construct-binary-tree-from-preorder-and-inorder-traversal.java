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
    static int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        preIndex = 0;
        return build(map,preorder,0,inorder.length-1);
    }
    static TreeNode build(HashMap<Integer,Integer> map, int[] preorder,int start,int end){
       if(start > end) return null;

       TreeNode root = new TreeNode(preorder[preIndex++]);

       int inorderIndex = map.get(root.val);
       
        root.left = build(map,preorder,start,inorderIndex-1);
       
        root.right = build(map,preorder,inorderIndex+1,end);

        return root;
    }
}