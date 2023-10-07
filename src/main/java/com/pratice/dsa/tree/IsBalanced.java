package com.pratice.dsa.tree;

public class IsBalanced {
    private boolean result = true;

    public static void main(String[] args) {

        int[] values = {10, 5, 15, 3, 7, 12, 17};

        BinaryTree tree = new BinaryTree();

        for (int value : values) {
            tree.insert(value);
        }

        System.out.println(new IsBalanced().isBalanced(tree.getRoot()));


    }

    private boolean isBalanced(TreeNode<Integer> root) {

        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return 1 + Math.max(left, right);
    }
}
