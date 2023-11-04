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


        // Calculate and display the sum and average of dataPoints
        int sum = 0;
        for (int value : dataPoints) {
            sum += value; // sum = sum + value
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("\nThe average of the random array dataPoints is: " + average);
        System.out.println("The sum of the random array dataPoints is: " + sum);

        // Linear scan (search)
        int userValue1 = SafeInput.getRangedInt(in, "Enter an integer", 1, 100);

        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue1) {
                count++;
            }
        }
        System.out.println("The user's value " + userValue1 + " was found " + count + " times in the array.");

        int userValue2 = SafeInput.getRangedInt(in, "Enter another integer", 1, 100);

        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue2) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("The value " + userValue2 + " was found at array index " + position);
        } else {
            System.out.println("The value " + userValue2 + " was not found in the array.");
        }

        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int value : dataPoints) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println("The minimum value in dataPoints is: " + min);
        System.out.println("The maximum value in dataPoints is: " + max);

        System.out.println("\nAverage of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}
