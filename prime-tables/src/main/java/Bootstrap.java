import java.util.Arrays;
import java.util.List;

public class Bootstrap {

    public static void main(String [] args) {
        List<String> input = StandardIOUtils.readSystemIn();
        Integer [][] inputArray = new Integer[input.size()][];
        int i = 0;
        for (String inputLine : input) {
            inputArray[i++] = Arrays.stream(inputLine.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        }
        PrimeTablesSolution primeTablesSolution = new PrimeTablesSolution();
        int primeSums = primeTablesSolution.countPrimeSums(inputArray);
        StandardIOUtils.writeToSystemOut("" + primeSums);
    }
}
