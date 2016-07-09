import java.util.Arrays;
import java.util.List;

public class Bootstrap {
    public static void main(String[] args) {
        List<String> input = StandardIOUtils.readSystemIn();
        Integer[][] inputArray = new Integer[input.size()][];
        int i = 0;
        for (String inputLine : input) {
            try {
                inputArray[i++] = Arrays.stream(inputLine.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            } catch (NumberFormatException e) {
                StandardIOUtils.writeToSystemOut("Error: Could not parse integer from string for line: " + inputLine + ", exception message: " + e.getMessage());
            }
        }
        LazyHikerSolution lazyHikerSolution = new LazyHikerSolution();
        lazyHikerSolution.findLaziestPath(inputArray).forEach(StandardIOUtils::writeToSystemOut);
    }
}
