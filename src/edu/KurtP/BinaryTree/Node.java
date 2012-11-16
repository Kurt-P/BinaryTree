package edu.KurtP.BinaryTree;

/**
 * @author Kurt P
 * @version 1.0.11152012
 */
public class Node {

    protected Node left, right, parent;
    protected int value, rank;

    public Node(int value) {
        this.value = value;
    }

    /**
     * Get the rank of the
     * <code>parent node</code>
     *
     * @return rank
     */
    public int getParentRank() {
        return getParent().rank;
    }

    /**
     * Get the
     * <code>parent node</code> of a
     * <code>node</code>
     *
     * @return parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Check if a
     * <code>node</code> is a
     * <code>leaf</code>
     *
     * @return boolean
     */
    public boolean isLeaf() {
        return (right == null && left == null);
    }

    /**
     * Check if the node is the
     * <code>root node</code>
     *
     * @return boolean
     */
    public boolean isRoot() {
        return (parent == null);
    }

    /**
     * Checks if the current
     * <code>node</code> has
     * <code>children</code>
     *
     * @return boolean
     */
    public boolean hasChild() {
        return (left != null | right != null);
    }

    /**
     * Checks if the
     * <code>node</code> has a left child
     *
     * @return boolean
     */
    public boolean hasLeft() {
        return (left != null);
    }

    /**
     * Checks if the
     * <code>node</code> has a right child
     *
     * @return boolean
     */
    public boolean hasRight() {
        return (right != null);
    }

    /**
     * Gets the smallest child in a sub-tree.
     *
     * This method is to be used the delete method, when a node to be deleted
     * has children node. I'm not sure if it's returning the correct node. If it
     * isn't returning the correct node, then the delete method will not work.
     *
     * @return Node
     */
    public Node getSmallestChild() {
//        if (hasChild()) {
//            if (left.value < right.value) {
//                return left.getSmallestChild();
//            }
//            else {
//                return right.getSmallestChild();
//            }
//        }
//        return this;
        if (hasLeft()) {
            if (hasRight()) {
                if (right.value < left.value) {
                    return right.getSmallestChild();
                }
            }
            return right.getSmallestChild();
        }
        return this;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
