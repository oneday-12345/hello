package com.world.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    void pathSum1(TreeNode<Integer> root, int sum,
            List<TreeNode<Integer>> current,
            List<List<TreeNode<Integer>>> result) {

        if (root == null) {
            return;
        }

        // 在调用之前，需要 先把 root 节点，装入 current 中。
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                List<TreeNode<Integer>> al = new ArrayList<>(current);
                result.add(al);
            }
            return;
        }

        if (root.left != null) {
            sum -= root.left.value;
            current.add(root.left);
            pathSum1(root.left, sum, current, result);
            current.remove(current.size() - 1);
            sum += root.left.value;
        }

        if (root.right != null) {
            sum -= root.right.value;
            current.add(root.right);
            pathSum1(root.right, sum, current, result);
            current.remove(current.size() - 1);
            sum += root.right.value;
        }

    }

    void pathSum2(TreeNode<Integer> root, int sum,
            List<TreeNode<Integer>> current,
            List<List<TreeNode<Integer>>> result) {

        if (root == null) {
            return;
        }

        // 在调用之前，不需要 先把 root 节点，装入 current 中。
        if (root.left == null && root.right == null) {
            if (sum == root.value) {
                current.add(root);
                List<TreeNode<Integer>> al = new ArrayList<>(current);
                current.remove(current.size() - 1);
                result.add(al);
            }
            return;
        }

        if (root.left != null) {
            sum -= root.value;
            current.add(root);
            pathSum2(root.left, sum, current, result);
            current.remove(current.size() - 1);
            sum += root.value;
        }

        if (root.right != null) {
            sum -= root.value;
            current.add(root);
            pathSum2(root.right, sum, current, result);
            current.remove(current.size() - 1);
            sum += root.value;
        }

    }
}
