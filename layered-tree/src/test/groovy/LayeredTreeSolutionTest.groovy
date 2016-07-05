import spock.lang.Specification
import spock.lang.Unroll

import java.nio.charset.StandardCharsets

class LayeredTreeSolutionTest extends Specification {

    def LayeredTreeSolution layeredTreeSolution = new LayeredTreeSolution()

    @Unroll
    def "should create properly ordered tree" (String input, String expected) {
        given:
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))
        when:
        def result = layeredTreeSolution.solve()
        then:
        result == expected
        where:
        input               | expected
        "5,4,3,2,1"         | "1\n" +
                              "3,2\n" +
                              "4,5,_,_\n"
        "9,8,7,6,5,4,3,2,1" | "1\n" +
                              "3,2\n" +
                              "4,5,6,7\n" +
                              "_,_,_,_,_,_,9,8\n"
    }

    @Unroll
    def "first #n terms of geometric series of q = 2^n equals #expected" (int n, int expected) {
        expect:
        layeredTreeSolution.getSpacesAlreadyAvailable(n) == expected
        where:
        n | expected
        1 | 1
        2 | 3
        3 | 7
        4 | 15
    }
}
