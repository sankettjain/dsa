package com.pratice.dsa.tree;

public class BinaryTree {
    private TreeNode<Integer> root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode<Integer> root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public void inOrderTraversal(TreeNode<Integer> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        int[] values = {10, 5, 15, 3, 7, 12, 17};

        BinaryTree tree = new BinaryTree();

        for (int value : values) {
            tree.insert(value);
        }

        tree.inOrderTraversal(tree.root);
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }
}
