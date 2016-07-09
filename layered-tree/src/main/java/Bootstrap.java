public class Bootstrap {

    public static void main(String [] args) {
        LayeredTreeSolution layeredTreeSolution = new LayeredTreeSolution();
        String solution = "";
        try {
            solution = layeredTreeSolution.solve();
        } catch (NumberFormatException ignored) {}
        StandardIOUtils.writeToSystemOut(solution);
    }
}
