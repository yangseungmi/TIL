2019 03 29


간단한 leetcode 문제 풀기

minimum-depth-of-binary-tree


Given binary tree [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```
return its minimum depth = 2.


```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int MinDepth(TreeNode root) {
           if(root == null) return 0;
       if(root.left == null) return MinDepth(root.right) +1;
        if(root.right == null) return MinDepth(root.left)+1;
        
        return MinDepth(root.left) > MinDepth(root.right) ? MinDepth(root.right) +1: MinDepth(root.left) +1;
    }
}
```

