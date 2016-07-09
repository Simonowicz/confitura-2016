package model;

public class DepthFirstSearchState {
    private Integer[][] inputArray;
    private boolean[][] alreadyVisited;
    private Coordinate coordinate;
    private int risesSoFar;
    private int dropsSoFar;
    private String path;

    public Integer[][] getInputArray() {
        return inputArray;
    }

    public boolean[][] getAlreadyVisited() {
        return alreadyVisited;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getRisesSoFar() {
        return risesSoFar;
    }

    public int getDropsSoFar() {
        return dropsSoFar;
    }

    public String getPath() {
        return path;
    }

    public static final class DepthFirstSearchStatusBuilder {
        private Integer[][] inputArray;
        private boolean[][] alreadyVisited;
        private Coordinate coordinate;
        private int risesSoFar;
        private int dropsSoFar;
        private String path;

        private DepthFirstSearchStatusBuilder() {
        }

        public static DepthFirstSearchStatusBuilder aDepthFirstSearchStatus() {
            return new DepthFirstSearchStatusBuilder();
        }

        public DepthFirstSearchStatusBuilder withInputArray(Integer[][] inputArray) {
            this.inputArray = inputArray;
            return this;
        }

        public DepthFirstSearchStatusBuilder withAlreadyVisited(boolean[][] alreadyVisited) {
            this.alreadyVisited = alreadyVisited;
            return this;
        }

        public DepthFirstSearchStatusBuilder withCoordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
            return this;
        }

        public DepthFirstSearchStatusBuilder withRisesSoFar(int risesSoFar) {
            this.risesSoFar = risesSoFar;
            return this;
        }

        public DepthFirstSearchStatusBuilder withDropsSoFar(int dropsSoFar) {
            this.dropsSoFar = dropsSoFar;
            return this;
        }

        public DepthFirstSearchStatusBuilder withPath(String path) {
            this.path = path;
            return this;
        }

        public DepthFirstSearchState build() {
            DepthFirstSearchState depthFirstSearchState = new DepthFirstSearchState();
            depthFirstSearchState.inputArray = this.inputArray;
            depthFirstSearchState.alreadyVisited = this.alreadyVisited;
            depthFirstSearchState.coordinate = this.coordinate;
            depthFirstSearchState.risesSoFar = this.risesSoFar;
            depthFirstSearchState.dropsSoFar = this.dropsSoFar;
            depthFirstSearchState.path = this.path;
            return depthFirstSearchState;
        }
    }
}
