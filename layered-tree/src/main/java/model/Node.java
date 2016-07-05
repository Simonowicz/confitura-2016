package model;

public class Node {
    private Integer value;
    private Node left;
    private Node right;

    private Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void createChildren() {
        left = new Node();
        right = new Node();
    }

    @Override
    public String toString() {
        return value != null ? value.toString() : "_";
    }

}
