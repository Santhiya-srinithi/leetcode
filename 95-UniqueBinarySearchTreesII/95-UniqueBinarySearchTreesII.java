// Last updated: 7/25/2026, 11:13:05 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<TreeNode> generateTrees(int n) {
18        return n > 0 ? generate_trees(1, n) : new ArrayList<>();
19    }
20
21    private List<TreeNode> generate_trees(int start, int end) {
22        List<TreeNode> all_trees = new ArrayList<>();
23        if (start > end) {
24            all_trees.add(null);
25            return all_trees;
26        }
27
28        for (int i = start; i <= end; i++) {
29            List<TreeNode> left_trees = generate_trees(start, i - 1);
30            List<TreeNode> right_trees = generate_trees(i + 1, end);
31
32            for (TreeNode l : left_trees) {
33                for (TreeNode r : right_trees) {
34                    TreeNode current_tree = new TreeNode(i);
35                    current_tree.left = l;
36                    current_tree.right = r;
37                    all_trees.add(current_tree);
38                }
39            }
40        }
41        return all_trees;
42    }
43}