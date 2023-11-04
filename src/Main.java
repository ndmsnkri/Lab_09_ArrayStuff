import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Scanner in = new Scanner(System.in);

        // Initialize dataPoints array with random values between 1 and 100
        Random rand = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        // Display dataPoints values
        for (int value : dataPoints) {
            System.out.print(value + " | ");
        }

        // Calculate and display the sum and average of dataPoints using the static methods
        int sum = sum(dataPoints);
        double average = (double) sum / dataPoints.length;
        System.out.println("\nThe average of the random array dataPoints is: " + average);
        System.out.println("The sum of the random array dataPoints is: " + sum);

        // Linear scan (search)
        int userValue1 = SafeInput.getRangedInt(in, "Enter an integer", 1, 100);

        int count = occuranceScan(dataPoints, userValue1);
        System.out.println("The user's value " + userValue1 + " was found " + count + " times in the array.");

        int userValue2 = SafeInput.getRangedInt(in, "Enter another integer", 1, 100);

        int position = findFirstOccurrence(dataPoints, userValue2);
        if (position != -1) {
            System.out.println("The value " + userValue2 + " was found at array index " + position);
        } else {
            System.out.println("The value " + userValue2 + " was not found in the array.");
        }

        int minValue = min(dataPoints);
        int maxValue = max(dataPoints);

        System.out.println("The minimum value in dataPoints is: " + minValue);
        System.out.println("The maximum value in dataPoints is: " + maxValue);

        System.out.println("\nAverage of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = sum(values);
        return (double) sum / values.length;
    }

    public static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int occuranceScan(int[] values, int target) {
        int count = 0;
        for (int value : values) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static boolean contains(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static int findFirstOccurrence(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
