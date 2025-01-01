package com.world.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder<E> {

    List<List<TreeNode<E>>> levelOrder(TreeNode<E> root) {

        List<List<TreeNode<E>>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode<E>> current = new LinkedList<>();
        Queue<TreeNode<E>> next = new LinkedList<>();

        current.offer(root);

        List<TreeNode<E>> al = new ArrayList<>();

        while (!current.isEmpty()) {

            TreeNode<E> node = current.poll();
            al.add(node);

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                result.add(al);
                al = new ArrayList<>();
            }
        }

        return result;
    }

    void dfs(TreeNode<E> root, int depth, List<List<TreeNode<E>>> result) {
        if (root == null) {
            return;
        }

        if (depth >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(root);

        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }

    List<List<TreeNode<E>>> bfs(TreeNode<E> root) {

        List<List<TreeNode<E>>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<TreeNode<E>> current = new ArrayList<>();

            for (int size = queue.size(), i = 0; i < size; ++i) {

                TreeNode<E> node = queue.poll();

                current.add(node);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            List<TreeNode<E>> al = new ArrayList<>(current);
            result.add(al);
        }

        return result;
    }

}
