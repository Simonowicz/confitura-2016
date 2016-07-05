import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

class StandardIOUtils {
    static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Stream<String> readSystemIn() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.lines();
    }

    static void writeToSystemOut(String output) {
        System.out.println(output);
    }
}
