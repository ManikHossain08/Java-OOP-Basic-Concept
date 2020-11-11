package Lab_6;

public class Construct_BinaryTree
{
    private static Node15 root;

    public Construct_BinaryTree(int data)
    {
        root = new Node15(data);
    }

    public void add(Node15 parent, Node15 child, String orientation)
    {
        if (orientation.equals("left"))
        {
           parent.setLeft(child);
        }
        else
        {
            parent.setRight(child);
        }
    }

    public static void main(String args[])
    {
        Node15 n1 = new Node15(1);
        Node15 n2 = new Node15(4);
        Node15 n3 = new Node15(2);
        Node15 n4 = new Node15(5);

        Construct_BinaryTree tree = new Construct_BinaryTree(3); //  3
        tree.add(root, n1, "left"); //         1/ \
        tree.add(root, n2, "right"); //            4
        tree.add(n2, n3, "left"); //             2/ \
        tree.add(n2, n4, "right"); //                5
    }
}

class Node15 {
    private int key;
    private Node15 left;
    private Node15 right;

    Node15 (int key) {
        this.key = key;
        right = null;
        left = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(Node15 left) {
        this.left = left;
    }

    public Node15 getLeft() {
        return left;
    }

    public void setRight(Node15 right ) {
        this.right = right;
    }

    public Node15 getRight() {
        return right;
    }

}
