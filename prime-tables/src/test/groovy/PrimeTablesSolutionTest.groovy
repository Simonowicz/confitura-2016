import spock.lang.Specification
import spock.lang.Unroll

class PrimeTablesSolutionTest extends Specification {

    def PrimeTablesSolution primeTablesSolution = new PrimeTablesSolution()

    @Unroll
    def "should return number of sub table sums that are prime numbers"(Integer[][] inputArray, int primeSumsCount) {
        expect:
        primeTablesSolution.countPrimeSums(inputArray) == primeSumsCount
        where:
        inputArray                                 | primeSumsCount
        [[1, 1, 1, 1], [1, 2, 1, 1], [1, 1, 1, 1]] | 10
        [[1]]                                      | 0
        [[1, 1], [1, 2]]                           | 1
    }
}
