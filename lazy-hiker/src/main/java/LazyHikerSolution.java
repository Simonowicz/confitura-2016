import model.Coordinate;
import model.DepthFirstSearchState;

import java.util.ArrayList;
import java.util.List;

public class LazyHikerSolution {

    private List<String> bestSolutions = new ArrayList<>();
    private int bestSolutionRises = Integer.MAX_VALUE;
    private int bestSolutionDrops = Integer.MAX_VALUE;

    public List<String> findLaziestPath(Integer[][] inputArray) {
        boolean[][] alreadyVisited = new boolean[inputArray.length][inputArray[0].length];
        initDepthFirstSearch(inputArray, alreadyVisited);
        return bestSolutions;
    }

    private void initDepthFirstSearch(Integer[][] inputArray, boolean[][] alreadyVisited) {
        DepthFirstSearchState state = DepthFirstSearchState.DepthFirstSearchStatusBuilder.aDepthFirstSearchStatus()
                .withInputArray(inputArray)
                .withAlreadyVisited(alreadyVisited)
                .withCoordinate(new Coordinate(0, 0))
                .withRisesSoFar(0)
                .withDropsSoFar(0)
                .withPath("")
                .build();
        depthFirstSearch(state);
    }

    private void depthFirstSearch(DepthFirstSearchState state) {
        if (isTargetCoordinate(state)) {
            if (bestSolutionRises >= state.getRisesSoFar() && bestSolutionDrops >= state.getDropsSoFar()) {
                if (bestSolutionRises > state.getRisesSoFar() || bestSolutionDrops > state.getDropsSoFar()) {
                    bestSolutions.clear();
                    bestSolutionRises = state.getRisesSoFar();
                    bestSolutionDrops = state.getDropsSoFar();
                }
                bestSolutions.add(state.getPath());
            }
            return;
        }

        if (state.getRisesSoFar() <= bestSolutionRises) {
            state.getAlreadyVisited()[state.getCoordinate().getX()][state.getCoordinate().getY()] = true;

            goUpIfPossible(state);
            goLeftIfPossible(state);
            goRightIfPossible(state);
            goDownIfPossible(state);

            state.getAlreadyVisited()[state.getCoordinate().getX()][state.getCoordinate().getY()] = false;
        }
    }

    private boolean isTargetCoordinate(DepthFirstSearchState state) {
        Coordinate coordinate = state.getCoordinate();
        return coordinate.getX() == state.getInputArray().length - 1 && coordinate.getY() == state.getInputArray()[0].length - 1;
    }

    private void goUpIfPossible(DepthFirstSearchState state) {
        Coordinate upCoordinate = new Coordinate(state.getCoordinate().getX() - 1, state.getCoordinate().getY());
        if (upCoordinate.getX() >= 0 && !state.getAlreadyVisited()[upCoordinate.getX()][upCoordinate.getY()]) {
            depthFirstSearch(getNextStateFromCurrentStateAndNextCoordinate(state, upCoordinate, "U"));
        }
    }

    private void goLeftIfPossible(DepthFirstSearchState state) {
        Coordinate leftCoordinate = new Coordinate(state.getCoordinate().getX(), state.getCoordinate().getY() - 1);
        if (leftCoordinate.getY() >= 0 && !state.getAlreadyVisited()[leftCoordinate.getX()][leftCoordinate.getY()]) {
            depthFirstSearch(getNextStateFromCurrentStateAndNextCoordinate(state, leftCoordinate, "L"));
        }
    }

    private void goRightIfPossible(DepthFirstSearchState state) {
        Coordinate rightCoordinate = new Coordinate(state.getCoordinate().getX(), state.getCoordinate().getY() + 1);
        if (rightCoordinate.getY() < state.getInputArray()[0].length && !state.getAlreadyVisited()[rightCoordinate.getX()][rightCoordinate.getY()]) {
            depthFirstSearch(getNextStateFromCurrentStateAndNextCoordinate(state, rightCoordinate, "R"));
        }
    }

    private void goDownIfPossible(DepthFirstSearchState state) {
        Coordinate downCoordinate = new Coordinate(state.getCoordinate().getX() + 1, state.getCoordinate().getY());
        if (downCoordinate.getX() < state.getInputArray().length && !state.getAlreadyVisited()[downCoordinate.getX()][downCoordinate.getY()]) {
            depthFirstSearch(getNextStateFromCurrentStateAndNextCoordinate(state, downCoordinate, "D"));
        }
    }

    private DepthFirstSearchState getNextStateFromCurrentStateAndNextCoordinate(DepthFirstSearchState state, Coordinate nextCoordinate, String move) {
        int change = state.getInputArray()[nextCoordinate.getX()][nextCoordinate.getY()] -
                state.getInputArray()[state.getCoordinate().getX()][state.getCoordinate().getY()];
        int rise = 0, drop = 0;
        if (change > 0) {
            rise = change;
        } else {
            drop = change * -1;
        }
        return DepthFirstSearchState.DepthFirstSearchStatusBuilder.aDepthFirstSearchStatus()
                .withInputArray(state.getInputArray())
                .withAlreadyVisited(state.getAlreadyVisited())
                .withRisesSoFar(state.getRisesSoFar() + rise)
                .withDropsSoFar(state.getDropsSoFar() + drop)
                .withCoordinate(nextCoordinate)
                .withPath(state.getPath() + move)
                .build();
    }

}
