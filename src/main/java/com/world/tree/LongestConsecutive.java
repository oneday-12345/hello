package com.world.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.world.utils.Utils;

class Wrapper<E> {
    TreeNode<E> node;
    int length;

    public Wrapper(TreeNode<E> node, int length) {
        this.node = node;
        this.length = length;
    }
}

public class LongestConsecutive<E extends Integer> {

    int longestConsecutiveSequence(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        int max = 0;

        Queue<Wrapper<E>> queue = new LinkedList<>();
        queue.offer(new Wrapper<>(root, 1));

        while (!queue.isEmpty()) {

            Wrapper<E> w = queue.poll();

            TreeNode<E> node = w.node;
            int length = w.length;

            max = Math.max(length, max);

            if (node.left != null) {
                if (node.left.value - 1 == node.value) {
                    queue.offer(new Wrapper<>(node.left, length + 1));
                } else {
                    queue.offer(new Wrapper<>(node.left, 1));
                } // if
            } // if

            if (node.right != null) {
                if (node.right.value - 1 == node.value) {
                    queue.offer(new Wrapper<>(node.right, length + 1));
                } else {
                    queue.offer(new Wrapper<>(node.right, 1));
                } // if
            } // if

        } // for

        return max;
    }

    int max = 0;

    int dfs(TreeNode<E> root) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int fromLeft = 1;
        int fromRight = 1;

        if (root.left == null) {
            fromLeft = 1;
        } else if (root.left.value - 1 == root.value) {
            fromLeft = left + 1;
        } else {
            fromLeft = 1;
        }

        if (root.right == null) {
            fromRight = 1;
        } else if (root.right.value - 1 == root.value) {
            fromRight = right + 1;
        } else {
            fromRight = 1;
        }

        max = Utils.max(fromLeft, fromRight, max);

        return Math.max(fromLeft, fromRight);
    }

}
