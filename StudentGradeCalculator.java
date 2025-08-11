import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ask number of students
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); //consume leftover newline

        //Arrays to store data
        String[] names = new String[numStudents];
        double[] marks = new double[numStudents];

        //Input loop
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            names[i] = sc.nextLine();
            System.out.print("Marks (out of 100): ");
            marks[i] = sc.nextDouble();
            sc.nextLine(); //consume newline
        }

        //Step 4: Processing
        System.out.println("\n--- Student Grades ---");
        double sum = 0;
        int highestIndex = 0, lowestIndex = 0;

        for (int i = 0; i < numStudents; i++) {
            String grade;
            if (marks[i] >= 90) {
                grade = "A";
            } else if (marks[i] >= 75) {
                grade = "B";
            } else if (marks[i] >= 50) {
                grade = "C";
            } else {
                grade = "Fail";
            }

            sum += marks[i];
            System.out.printf("%s - Marks: %.2f - Grade: %s%n", names[i], marks[i], grade);

            //Track highest and lowest marks
            if (marks[i] > marks[highestIndex]) {
                highestIndex = i;
            }
            if (marks[i] < marks[lowestIndex]) {
                lowestIndex = i;
            }
        }

        //Calculate Average
        double average = sum / numStudents;
        System.out.printf("\nClass Average Marks: %.2f%n", average);

        //Display highest and lowest scorer
        System.out.printf("Top Scorer: %s (%.2f marks)%n", names[highestIndex], marks[highestIndex]);
        System.out.printf("Lowest Scorer: %s (%.2f marks)%n", names[lowestIndex], marks[lowestIndex]);

        sc.close();
    }
}
