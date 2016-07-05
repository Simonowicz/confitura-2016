public class Bootstrap {

    public static void main(String [] args) {
        LayeredTreeSolution layeredTreeSolution = new LayeredTreeSolution();
        String solution = layeredTreeSolution.solve();
        StandardIOUtils.writeToSystemOut(solution);
    }
}
