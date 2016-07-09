package model;

import java.util.LinkedList;

public class Tree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<Node> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        LinkedList<Node> nextLevel = new LinkedList<>();
        while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
            Node currentNode = currentLevel.poll();
            stringBuilder.append(currentNode);
            if (currentNode.getLeft() != null) {
                nextLevel.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                nextLevel.add(currentNode.getRight());
            }
            if (currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
                stringBuilder.append("\n");
            } else {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
