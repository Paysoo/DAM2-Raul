package M3.UF5.NF3.Activitat1;

public class ArraySumTester {
    public static void main(String[] args) {
        int[] arrayNumbers = {0, 1, 2, 3};
        int sum = 0;

        for (int i = 0; i < arrayNumbers.length; i++) {
            sum += arrayNumbers[i];
        }

        System.out.println("Sum of all numbers = " + sum);
    }
}
