
/*
783. Minimum Distance Between BST Nodes
https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 완전 잼병인 트리문제이다.
 그래도 이번에 공부하면서
 전위 순회(부모->좌->우),
 중위 순회(좌->부모->우),
 후위 순회(좌->우->부모)를 다시한번 더 정리하였다.
 TreeNode
*/

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

    private static TreeNode previous = null;
    private static int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        
        findMinDiffInBST(root);
        return min;
    }
    private static void findMinDiffInBST(TreeNode root) {
        if(root == null){
            return;
        }
        
        findMinDiffInBST(root.left);
        if(previous != null){
            min = Math.min(min, Math.abs(root.val - previous.val));
        }
        previous = root;
        findMinDiffInBST(root.right);
    }
}
