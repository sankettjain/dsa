package com.pratice.dsa.tree;

import org.antlr.v4.runtime.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {


    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;

    }

    public static int maxDepthBFS(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> data = new LinkedList<>();
        data.add(root);
        int level = 0;
        while (!data.isEmpty()) {
            int size = data.size();
            while (size > 0) {
                TreeNode node = data.poll();
                if (node.left != null) {
                    data.add(node.left);
                }
                if (node.right != null) {
                    data.add(node.right);
                }
                size--;
            }
            level += 1;
        }
        return level;

    }


    public static void main(String[] args) {
        int[] values = {10, 5, 15, 3, 7, 12, 17};

        BinaryTree tree = new BinaryTree();

        for (int value : values) {
            tree.insert(value);
        }

        System.out.println(maxDepth(tree.getRoot()));
        System.out.println(maxDepthBFS(tree.getRoot()));
    }

}
