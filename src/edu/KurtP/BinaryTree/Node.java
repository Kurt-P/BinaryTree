package edu.KurtP.BinaryTree;

/**
 * @author Kurt P
 * @version 0.3.11102012
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
    
    public boolean hasLeft() {
        return (left != null);
    }
    
    public boolean hasRight() {
        return (right != null);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
