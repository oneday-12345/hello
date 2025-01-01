package com.world.tree;

import java.util.Stack;

public class BSTIterator<E> {

    TreeNode<E> root;

    Stack<TreeNode<E>> stack;

    public BSTIterator(TreeNode<E> root) {

        stack = new Stack<>();

        this.root = root;
        TreeNode<E> p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    TreeNode<E> next() {
        if (!hasNext()) {
            return null;
        }
        TreeNode<E> node = stack.pop();
        TreeNode<E> p = node;
        p = p.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return node;
    }
}
