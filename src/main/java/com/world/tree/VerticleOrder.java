package com.world.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticleOrder<E> {

    public static class Wrapper<E> {
        TreeNode<E> node;
        int level;

        public Wrapper(TreeNode<E> node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    List<List<TreeNode<E>>> verticalOrder(TreeNode<E> root) {

        List<List<TreeNode<E>>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, List<TreeNode<E>>> map = new HashMap<>();

        Queue<Wrapper<E>> queue = new LinkedList<>();
        queue.offer(new Wrapper<E>(root, 0));
        while (!queue.isEmpty()) {
            Wrapper<E> w = queue.poll();
            TreeNode<E> node = w.node;
            int level = w.level;

            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<TreeNode<E>>());
            }
            map.get(level).add(node);

            min = Math.min(level, min);
            max = Math.min(level, max);

            if (node.left != null) {
                queue.offer(new Wrapper<E>(node.left, level - 1));
            }

            if (node.right != null) {
                queue.offer(new Wrapper<E>(node.right, level + 1));

            }
        }

        for (int level = min; level < max; ++level) {
            if (!map.containsKey(level)) {
                continue;
            }
            result.add(map.get(level));
        }

        return result;
    }

}
