package com.world.tree;

public class LowestCommonAncestor {

    <E> TreeNode<E> lowestCommonAncestor(TreeNode<E> root, TreeNode<E> p, TreeNode<E> q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode<E> left = lowestCommonAncestor(root.left, p, q);
        TreeNode<E> right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        return null;
    }

    <E extends Comparable<E>> TreeNode<E> lowestCommonAncestorBST(TreeNode<E> root, TreeNode<E> p, TreeNode<E> q) {

        if (root == null) {
            return root;
        }

        if (root.value.compareTo(p.value) > 0 && root.value.compareTo(q.value) < 0) {
            return root;
        } else if (root.value.compareTo(p.value) < 0 && root.value.compareTo(q.value) < 0) {
            return lowestCommonAncestorBST(root.right, p, q); // 夹逼准则，朝着目标前进 // 很容易出错
        } else if (root.value.compareTo(p.value) > 0 && root.value.compareTo(q.value) > 0) {
            return lowestCommonAncestorBST(root.left, p, q); // 夹逼准则，朝着目标前进 // 很容易出错
        }

        return null;
    }

    public static class WrapperTreeNode<E> {
        TreeNode<E> node;
        int count;

        public WrapperTreeNode(TreeNode<E> node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    <E> WrapperTreeNode<E> lowestCommonAncestor2(TreeNode<E> root, TreeNode<E> p, TreeNode<E> q) {

        if (root == null) {
            return new WrapperTreeNode<>(null, 0);
        }

        WrapperTreeNode<E> left = lowestCommonAncestor2(root.left, p, q);
        WrapperTreeNode<E> right = lowestCommonAncestor2(root.right, p, q);

        if (left.count == 2) {
            return left;
        }

        if (right.count == 2) {
            return right;
        }

        int count = left.count + right.count;

        WrapperTreeNode<E> wrapper = new WrapperTreeNode<>(root, count);

        if (root == p) {
            ++wrapper.count;
        }

        if (root == q) {
            ++wrapper.count;
        }

        return wrapper;
    }

}
