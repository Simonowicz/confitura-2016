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
        List<Integer> sortedIntegers;
        try {
            sortedIntegers = Arrays.stream(inputLine.split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            StandardIOUtils.writeToSystemOut("Error: Number format exception caught when trying to parse: " + inputLine + ", exception message: " + e.getMessage());
            throw e;
        }
        return createAndPopulateTree(sortedIntegers);
    }

    private Tree createAndPopulateTree(List<Integer> sortedIntegers) {
        Tree tree = new Tree();
        if (!sortedIntegers.isEmpty()) {
            PopulatingMode populatingMode = PopulatingMode.ODD;
            LinkedList<Node> currentLevelNodes = new LinkedList<>();
            LinkedList<Node> nextLevelNodes = new LinkedList<>();
            int currentLevel = 1;
            for (int i = 0; i < sortedIntegers.size(); i++) {
                boolean flipPopulatingMode = false;
                Node currentNode = currentLevelNodes.poll();
                if (currentNode == null) {
                    currentNode = new Node(sortedIntegers.get(i));
                    tree.setRoot(currentNode);
                }
                if (currentLevelNodes.isEmpty()) {
                    flipPopulatingMode = true;
                }
                currentNode.setValue(sortedIntegers.get(i));
                createChildrenIfNecessary(sortedIntegers, currentNode, currentLevel);
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

    private void createChildrenIfNecessary(List<Integer> sortedIntegers, Node node, int currentLevel) {
        if (getSpacesAlreadyAvailable(currentLevel) < sortedIntegers.size()) {
            node.createChildren();
        }
    }

    int getSpacesAlreadyAvailable(int currentLevel) {
        return (int) ((1 - Math.pow(2, currentLevel)) / -1);
    }
}
