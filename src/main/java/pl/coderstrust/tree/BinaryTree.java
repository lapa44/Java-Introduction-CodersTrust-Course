package pl.coderstrust.tree;

import java.util.ArrayList;

public class BinaryTree {

    Node root;

    private boolean find(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        else {
            return node.value > value ? find(node.left, value) : find(node.right, value);
        }
    }

    public boolean find(int value) {
        return find(root, value);
    }

    private Node add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        else if(value < node.value) {
            node.left = add(node.left, value);
        }
        else if(value > node.value) {
            node.right = add(node.right, value);
        }
        else {
            return node;
        }
        return node;
    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            if (node.left == null && node.right == null) {
                return null;
            }
            else if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else {
                node.value = minValue(node.right);
                node.right = delete(node.right, node.value);
                return node;
            }
        }
        else if (value < node.value) {
            node.left = delete(node.left, value);
        }
        else {
            node.right = delete(node.right, value);
        }
        node.right = delete(node.right, value);
        return node;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private int minValue(Node node) {
        return node.left == null ? node.value : minValue(node.left);
    }

    public ArrayList<Integer> getInOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        getInOrder(root, result);
        return result;
    }

    public void getInOrder(Node node, ArrayList<Integer> result) {
        if (node != null) {
            getInOrder(node.left, result);
            result.add(node.value);
            getInOrder(node.right, result);
        }
    }

    public ArrayList<Integer> getPreOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        getPreOrder(root, result);
        return result;
    }

    public void getPreOrder(Node node, ArrayList<Integer> result) {
        if (node != null) {
            result.add(node.value);
            getPreOrder(node.left, result);
            getPreOrder(node.right, result);
        }
    }

    public ArrayList<Integer> getPostOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        getPostOrder(root, result);
        return result;
    }

    public void getPostOrder(Node node, ArrayList<Integer> result) {
        if (node != null) {
            getPostOrder(node.left, result);
            getPostOrder(node.right, result);
            result.add(node.value);
        }
    }
}
