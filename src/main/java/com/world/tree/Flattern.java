package com.world.tree;

import java.util.Stack;

public class Flattern<E> {

    /*
     *             1
     * 
     *         2         7
     * 
     *     3     4            8
     * 
     *             5              9
     * 
     *                 6
     */
    TreeNode<E> flattern(TreeNode<E> root) {

        if (root == null) {
            return null;
        }

        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> p = root;

        // 中序遍历
        while (p != null || !stack.isEmpty()) {

            if (p.right != null) {
                stack.push(p.right);
                p.right = null;
            }

            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                TreeNode<E> t = stack.pop();
                p.right = t;
            }

            p = p.right;
        }

        return root;
    }
}
