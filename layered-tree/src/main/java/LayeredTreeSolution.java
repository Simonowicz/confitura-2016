import model.Node;
import model.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LayeredTreeSolution {

    public String solve() {
        Tree tree = prepareTree(StandardIOUtils.readLine());
        return tree.toString();
    }

    private Tree prepareTree(String inputLine) {
        Tree tree = new Tree();
        List<Integer> sortedIntegers;
        try {
            sortedIntegers = Arrays.stream(inputLine.split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            StandardIOUtils.writeToSystemOut("Error: Number format exception caught when trying to parse: " + inputLine);
            throw e;
        }
        if (!sortedIntegers.isEmpty()) {
            Node root = new Node(sortedIntegers.get(0));
            root.createChildren();
            tree.setRoot(root);
            PopulatingMode populatingMode = PopulatingMode.EVEN;
            LinkedList<Node> currentLevelNodes = new LinkedList<>();
            currentLevelNodes.addAll(Arrays.asList(root.getRight(), root.getLeft()));
            LinkedList<Node> nextLevelNodes = new LinkedList<>();
            int currentLevel = 2;
            for (int i = 1; i < sortedIntegers.size(); i++) {
                boolean flipPopulatingMode = false;
                Node currentNode = currentLevelNodes.poll();
                if (currentLevelNodes.isEmpty()) {
                    flipPopulatingMode = true;
                }
                currentNode.setValue(sortedIntegers.get(i));
                if (getSpacesAlreadyAvailable(currentLevel) < sortedIntegers.size()) {
                    currentNode.createChildren();
                }
                if (populatingMode == PopulatingMode.EVEN) {
                    nextLevelNodes.addFirst(currentNode.getRight());
                    nextLevelNodes.addFirst(currentNode.getLeft());
                } else {
                    nextLevelNodes.addFirst(currentNode.getLeft());
                    nextLevelNodes.addFirst(currentNode.getRight());
                }
                if (flipPopulatingMode) {
                    currentLevelNodes = nextLevelNodes;
                    nextLevelNodes = new LinkedList<>();
                    populatingMode = populatingMode.flip();
                    currentLevel++;
                }
            }
        }
        return tree;
    }

    int getSpacesAlreadyAvailable(int currentLevel) {
        return (int) ((1 - Math.pow(2, currentLevel)) / -1);
    }
}
