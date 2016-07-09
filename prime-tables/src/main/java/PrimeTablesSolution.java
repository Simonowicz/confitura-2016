import java.math.BigInteger;

public class PrimeTablesSolution {

    private static final int PRIME_CERTAINTY = 6;

    public int countPrimeSums(Integer[][] inputArray) {
        int primeNumbersCount = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = 0; j < inputArray[i].length - 1; j++) {
                primeNumbersCount += countPrimeSumsInSubTablesStartingFrom(inputArray, i, j);
            }
        }
        return primeNumbersCount;
    }

    private int countPrimeSumsInSubTablesStartingFrom(Integer[][] inputArray, int startRow, int startColumn) {
        int primeNumbersCount = 0;
        int initialSum = countInitialSum(inputArray, startRow, startColumn);
        if (isPrime(initialSum)) {
            primeNumbersCount++;
        }
        primeNumbersCount += expandVerticallyAndCountPrimeNumbers(inputArray, startRow, startColumn, initialSum);
        primeNumbersCount += expandHorizontallyAndCountPrimeNumbers(inputArray, startRow, startColumn, initialSum);
        primeNumbersCount += expandDiagonallyAndCountPrimeNumbers(inputArray, startRow, startColumn, initialSum);
        return primeNumbersCount;
    }

    private int countInitialSum(Integer[][] inputArray, int startRow, int startColumn) {
        return inputArray[startRow][startColumn] + inputArray[startRow][startColumn+1] + inputArray[startRow+1][startColumn] + inputArray[startRow+1][startColumn+1];
    }

    private boolean isPrime(int primeCandidate) {
        return BigInteger.valueOf(primeCandidate).isProbablePrime(PRIME_CERTAINTY);
    }

    private int expandVerticallyAndCountPrimeNumbers(Integer[][] inputArray, int startRow, int startColumn, int previousSum) {
        int primeNumbersCount = 0;
        for (int horizontalIncrement = startRow + 2; horizontalIncrement < inputArray.length; horizontalIncrement++) {
            previousSum += inputArray[horizontalIncrement][startColumn] + inputArray[horizontalIncrement][startColumn+1];
            if (isPrime(previousSum)) {
                primeNumbersCount++;
            }
        }
        return primeNumbersCount;
    }

    private int expandHorizontallyAndCountPrimeNumbers(Integer[][] inputArray, int startRow, int startColumn, int previousSum) {
        int primeNumbersCount = 0;
        for (int verticalIncrement = startColumn + 2; verticalIncrement < inputArray[0].length; verticalIncrement++) {
            previousSum += inputArray[startRow][verticalIncrement] + inputArray[startRow + 1][verticalIncrement];
            if (isPrime(previousSum)) {
                primeNumbersCount++;
            }
        }
        return primeNumbersCount;
    }

    private int expandDiagonallyAndCountPrimeNumbers(Integer[][] inputArray, int startRow, int startColumn, int previousSum) {
        int primeNumbersCount = 0;
        int diagonalDifference = Math.min(inputArray.length - startRow, inputArray[0].length - startColumn);
        if (diagonalDifference > 2) {
            for (int diagonalIncrement = 2; diagonalIncrement < diagonalDifference; diagonalIncrement++) {
                previousSum += countDiagonalSum(inputArray, startRow, startColumn, startRow + diagonalIncrement, startColumn + diagonalIncrement);
                if (isPrime(previousSum)) {
                    primeNumbersCount++;
                }
            }
        }
        return primeNumbersCount;
    }

    private int countDiagonalSum(Integer[][] inputArray, int startRow, int startColumn, int diagonalRow, int diagonalColumn) {
        int sum = 0;
        for (int i = startColumn; i <= diagonalColumn; i++) {
            sum += inputArray[diagonalRow][i];
        }
        for (int i = startRow; i < diagonalRow; i++) {
            sum += inputArray[i][diagonalColumn];
        }
        return sum;
    }
}
