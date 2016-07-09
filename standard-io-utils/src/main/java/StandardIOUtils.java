import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StandardIOUtils {
    static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static List<String> readSystemIn() {
        List<String> inputLines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nextLine;
        while (!(nextLine = scanner.nextLine()).equals("")) {
            inputLines.add(nextLine);
        }
        return inputLines;
    }

    static void writeToSystemOut(String output) {
        System.out.println(output);
    }
}
