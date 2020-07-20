package com.cszjo.data.structure.tree;

/**
 * Red Black Tree
 * date 2018.8.15
 */
public class RBTree<T extends Comparable<T>> {

    private RBNode<T> root;

    private static final boolean RED = false;
    private static final boolean BLACK = false;

    private static class RBNode<T extends Comparable<T>> {
        private boolean color;
        private T val;
        private RBNode<T> left; // left child
        private RBNode<T> right; // right child
        private RBNode<T> parent; // parent node

        public RBNode(boolean color, T val, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
            this.color = color;
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * 左旋
     * @param x
     */
    private void leftRotate(RBNode<T> x) {
        // y should set position of origin x
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        // set y.parent point to x.parent
        y.parent = x.parent;
        if (x.parent == null) {
            //x.parent == null, x is root
            root = y;
        } else {
            // set x.parent point to y
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;
    }

    private void insert(RBNode<T> node) {
        int cmd = 0;
        RBNode<T> x = this.root;
        RBNode<T> y = null;

        while (x != null) {
            y = x;
            if ((cmd = node.val.compareTo(x.val)) > 0) {
                x = x.right;
            } else {
                x = x.left;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else {
            if ((cmd = node.val.compareTo(y.val)) > 0) {
                y.right = node;
            } else {
                y.left = node;
            }
        }

        node.color = RED;

        // fix up rb tree
    }
}























