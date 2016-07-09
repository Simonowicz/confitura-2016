import spock.lang.Specification
import spock.lang.Unroll

class LazyHikerSolutionTest extends Specification {

    def LazyHikerSolution lazyHikerSolution = new LazyHikerSolution()

    @Unroll
    def "should find the laziest path for the laziest of hikers"(Integer[][] inputArray, List<String> expected) {
        expect:
        lazyHikerSolution.findLaziestPath(inputArray) == expected
        where:
        inputArray                                                                            | expected
        [[1, 1, 1, 1], [1, 2, 3, 1], [1, 5, 3, 1], [1, 1, 1, 1]]                              | ['RRRDDD', 'DDDRRR']
        [[1, 2, 1, 1, 1], [1, 2, 1, 2, 1], [1, 2, 1, 2, 1], [1, 2, 1, 2, 1], [1, 1, 1, 2, 1]] | ['DDDDRRUUUURRDDDD'] // aka snake path
    }
}
