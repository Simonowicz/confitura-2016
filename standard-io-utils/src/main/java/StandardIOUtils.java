import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class StandardIOUtils {
    static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static List<String> readSystemIn() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.lines().collect(Collectors.toList());
    }

    static void writeToSystemOut(String output) {
        System.out.println(output);
    }
}
