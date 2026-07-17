// Last updated: 7/17/2026, 3:03:55 PM
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);      
        preorder(node.left, result); 
        preorder(node.right, result); 
    }
}