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
    static List<Integer> answer;
    public List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<Integer>();
        if(root == null)
            return answer;
        
        inorder(root);
        
        return answer;
    }
    
    public static void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			answer.add(root.val);
			inorder(root.right);
		}
	}
}

