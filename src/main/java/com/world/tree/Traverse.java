package com.world.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Traverse<E> {

    List<TreeNode<E>> preOrder(TreeNode<E> root) {

        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode<E>> stack = new Stack<>();

        // root, left, right
        // 所以 先入栈
        TreeNode<E> p = root;
        stack.push(p);

        while (!stack.isEmpty()) {

            TreeNode<E> node = stack.pop();

            result.add(node);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    List<TreeNode<E>> inOrder(TreeNode<E> root) {
        List<TreeNode<E>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode<E> p = root;
        Stack<TreeNode<E>> stack = new Stack<>();

        // left, root, right
        // 所以需要延迟入栈

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else if (!stack.isEmpty()) {
                TreeNode<E> t = stack.pop();
                result.add(t);
                p = t.right;
            }
        }
        return result;
    }

    List<TreeNode<E>> postOrder(TreeNode<E> root) {

        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);

        // left, right, root
        // 所以需要延迟出栈，这里先入栈，只是为了建立关系、处理关系

        TreeNode<E> prev = null;
        TreeNode<E> current = null;

        while (!stack.isEmpty()) {

            current = stack.peek();

            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    TreeNode<E> t = stack.pop();
                    result.add(t);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    TreeNode<E> t = stack.pop();
                    result.add(t);
                }
            } else if (current.right == prev) {
                TreeNode<E> t = stack.pop();
                result.add(t);
            }

            prev = current;
        }

        return result;
    }

}
