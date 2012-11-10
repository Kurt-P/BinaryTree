package edu.KurtP.BinaryTree;

import java.util.LinkedList;

/**
 * @author Kurt P
 * @version 0.0.11102012
 */
public class BinaryTree {

    private LinkedList list = new LinkedList();
    private Node root;

    /**
     * Create a new
     * <code>BinaryTree</code> with a
     * <code>root value</code>
     *
     * @param value
     */
    public BinaryTree(Node root) {
        list.add(0, null);
        this.root = root;
        this.root.rank = 1;
        list.add(root.rank, root);
    }

//    public BinaryTree() {
//        this(10);
//    }
    /**
     * Search the tree for a
     * <code>node</code> with a specific
     * <code>value</code>
     *
     * <p> Simular to the
     * <code>search</code> method, you need to specify which node to start at.
     * You should always start with the
     * </code>root node</code>. This will ensure no searching issues. </p>
     *
     * @param node
     * @param value
     */
    public void search(Node node, int value) {
        if (node.value == value) {
            System.out.printf("**The rank of the node with value: %d is %d**\n", value, node.rank);
        }
        else if (value < node.value) {
            if (node.left != null) {
                search(node.left, value);
            }
            else {
                System.out.printf("**Node with value: %d, does not exist**\n", value);
            }
        }
        else if (value > node.value) {
            if (node.right != null) {
                search(node.right, value);
            }
            else {
                System.out.printf("**Node with value: %d, does not exist**\n", value);
            }
        }
    }

    /**
     * Insert a
     * <code>node</code> with a
     * <code>value</code>.
     *
     * <p> When using the insert method you need to start with the
     * <code>root</code> node. Otherwise the node will not be inserted into the
     * list correctly. </p>
     *
     * @param node
     * @param value
     */
    public void insert(Node node, int value) {
        /*
         * Because not all Binary trees are balanced, the list needs to grow 
         * every time a new value is added, even if the value is not inserted 
         * into the index that is created. If a new new link is not made, and 
         * you try to insert a Node into an index that dose not exist yet, 
         * you will git a NullPointerExcepton. To redidy this, to the best of 
         * my knoledge, I just need to add an empty (null) node every time an 
         * element is added to the list. Which is why I have the list.add(null) 
         * at the begining of this method.
         */
        list.add(null);
        if (value < node.value) {
            if (node.left != null) {
//                list.add(null);
                insert(node.left, value);
            }
            else {
                System.out.println("**Inserted " + value + " to the left of " + node.value + "**");
                node.left = new Node(value);
                node.left.parent = node;
                node.left.rank = (node.left.getParentRank() * 2);
                list.add(node.left.rank, node.left);
            }
        }
        else if (value > node.value) {
            if (node.right != null) {
//                list.add(null);
                insert(node.right, value);
            }
            else {
                System.out.println("**Inserted " + value + " to the right of " + node.value + "**");
                node.right = new Node(value);
                node.right.parent = node;
                node.right.rank = (node.right.getParentRank() * 2) + 1;
                list.add(node.right.rank, node.right);
            }
        }
    }
    
    public void delete(Node node, int value) {
//        if (value == node.value && node.isLeaf()) {
//            node.parent = null;
//            //node.parent.
//            System.out.printf("**Deleted node with value: %d, and rank %d**\n", node.value, node.rank);
//            list.set(node.rank, null);
////            System.out.printf("Deleted node with value: %d, and rank %d", node.value, node.rank);
//        }
        if (value == node.value && node.hasChild()) {
            if (node.hasLeft()) {
                node.parent.left = node.getSmallestChild();
                System.out.printf("**Deleted node with value: %d, and rank %d**\n", node.value, node.rank);
                list.set(node.rank, null);
                node = null;
            }
            else {
                node.parent.right = node.right;
                System.out.printf("**Deleted node with value: %d, and rank %d**\n", node.value, node.rank);
                list.set(node.rank, null);
                node = null;
            }
        }
        else if (value < node.value) {
            if (node.left.value == value && node.left.isLeaf()) {
                System.out.printf("**Deleted node with value: %d, and rank %d**\n", node.left.value, node.left.rank);
                node.left = null;
            }
            if (node.left != null) {
                delete(node.left, value);
            }
        }
        else if (value > node.value) {
            if (node.right.value == value && node.right.isLeaf()) {
                System.out.printf("**Deleted node with value: %d, and rank %d**\n", node.right.value, node.right.rank);
                node.right = null;
            }
            if (node.right != null) {
                delete(node.right, value);
            }
        }
    }

    /**
     * Print the tree using an
     * <code>inorder</code> traversal.
     *
     * @param node
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            if (node.isLeaf()) {
                System.out.printf("**%d is a leaf**\n", node.value);
            }
            else if (node.isRoot()) {
                System.out.printf("**%d is root**\n", node.value);
            }
            else {
                System.out.printf("**Traversed %d**\n", node.value);
            }
            inorder(node.right);
        }
    }

    /**
     * Print out the tree using a
     * <code>preorder</code> traversal.
     *
     * @param node
     */
    public void preorder(Node node) {
        if (node.isRoot()) {
            System.out.printf("**%d is root**\n", node.value);
        }
        else if (node.isLeaf()) {
            System.out.printf("**%d is a leaf**\n", node.value);
        }
        else {
            System.out.printf("**Traversed %d**\n", node.value);
        }
        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    /**
     * Print out the tree using a
     * <code>postorder</code> traversal.
     *
     * @param node
     */
    public void postorder(Node node) {
        if (node.hasLeft()) {
            postorder(node.left);
        }
        if (node.hasRight()) {
            postorder(node.right);
        }
        if (node.isLeaf()) {
            System.out.printf("**%d is a leaf**\n", node.value);
        }
        else if (node.isRoot()) {
            System.out.printf("**%d is root**\n", node.value);
        }
        else {
            System.out.printf("**Traversed %d**\n", node.value);
        }
    }

    /**
     * Get the
     * <code>parent</code> of a node based on it's
     * <code>value</code>
     *
     * @param node
     * @param value
     */
    public void findParent(Node node, int value) {
        if (value == root.value) {
            System.out.println("**Root node has no parent :(**");
        }
        else if (value == node.value) {
            System.out.printf("**%d is the parent node of %d**\n", node.parent.value, value);
        }
        else if (value < node.value) {
            if (node.left != null) {
                findParent(node.left, value);
            }
            else {
                System.out.printf("**%d is the parent node of %d**\n", node.parent.value, value);
            }
        }
        else if (value > node.value) {
            if (node.right != null) {
                findParent(node.right, value);
            }
            else {
                System.out.printf("*!Node with value: %d, does not exist!*\n", value);
            }
        }
    }
}
