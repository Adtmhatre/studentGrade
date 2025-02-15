
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] subjects = {"English", "Physics", "Math", "Chemistry", "Biology"};
        double[] scores = new double[5];

        // Loop through each subject to collect scores
        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.print("Enter score for " + subjects[i] + " (Type 'exit' to quit): ");
                
                // Check if input is a number or 'exit'
                if (input.hasNextDouble()) {
                    double score = input.nextDouble();
                    
                    // Validate score range
                    if (score >= 0 && score <= 100) {
                        scores[i] = score;
                        break;
                    } else {
                        System.out.println("Invalid input. Please give your score in the 1-100 range. Type again.");
                    }
                } else if (input.hasNext("exit")) {
                    System.out.println("Exit...");
                    input.close();
                    return;
                } else {
                    System.out.println("Invalid input. Please enter a valid number or type 'exit' to quit.");
                    input.next(); // Clear invalid input
                }
            }
        }

        // Compute statistics
        double average = computeAverage(scores);
        double highest = getMaxScore(scores);
        double lowest = getMinScore(scores);

        // Display results
        System.out.println("\nStudent Scores:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%s: %.2f\n", subjects[i], scores[i]);
        }
        System.out.printf("\nAverage score: %.2f\n", average);
        System.out.printf("Highest score: %.2f\n", highest);
        System.out.printf("Lowest score: %.2f\n", lowest);

        input.close();
    }

    // Method to compute average score
    public static double computeAverage(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    // Method to find the highest score
    public static double getMaxScore(double[] scores) {
        double highest = scores[0];
        for (double score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    // Method to find the lowest score
    public static double getMinScore(double[] scores) {
        double lowest = scores[0];
        for (double score : scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        return lowest;
    }
}
