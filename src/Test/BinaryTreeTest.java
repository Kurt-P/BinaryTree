package Test;

import edu.KurtP.BinaryTree.BinaryTree;
import edu.KurtP.BinaryTree.Node;

public class BinaryTreeTest {
    public static void main(String[] args) {
        Node root = new Node(8);
        BinaryTree tree = new BinaryTree(root);
        
        System.out.println("Iserting the values");
//        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 4);
        tree.insert(root, 9);
        tree.insert(root, 5);
        tree.insert(root, 3);
        System.out.println();
        
        System.out.println("Finding the partent of 4");
        tree.findParent(root, 4);
        System.out.println();
        
        System.out.println("Printing tree using inorder method");
        tree.inorder(root);
        System.out.println();
        
        System.out.println("Printing tree using preorder method");
        tree.preorder(root);
        System.out.println();
        
        System.out.println("Printing tree using postorder method");
        tree.postorder(root);
        
        tree.delete(root, 6);
        
        System.out.println();
        tree.postorder(root);
    }
}
