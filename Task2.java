
import java.util.Scanner;

/*This program ask the user to input marks obtained in different subject and show the total marks, average marks and grade */

public class Task2 {

    // Make the totalMarks method static so it can be called from the static main
    // method
    public static int totalMarks(int engMarks, int socMarks, int sciMarks, int mathMarks, int hisMarks) {
        int total = engMarks + socMarks + sciMarks + mathMarks + hisMarks;
        return total;
    }

    public static int averageMarks(int total) {
        int average = total / 5;
        return average;
    }

    public static String gradeMarks(int average) {

        if (average > 90 && average <= 100) {
            return "Grade A+";
        } else if (average > 80) {
            return "Grade A";
        } else if (average > 70) {
            return "Grade B+";
        } else if (average > 60) {
            return "Grade B";
        } else if (average > 50) {
            return "Grade C+";
        } else if (average > 40) {
            return "Grade D";
        } else {
            return "fail";
        }
    }

    public static void main(String[] args) {
        // Declare marks for each subject
        int engMarks, socMarks, sciMarks, mathMarks, hisMarks;
        Scanner sc = new Scanner(System.in);

        // Prompt user for marks in each subject
        System.out.println("Enter your marks in English:");
        engMarks = sc.nextInt();

        System.out.println("Enter your marks in Social:");
        socMarks = sc.nextInt();

        System.out.println("Enter your marks in Science:");
        sciMarks = sc.nextInt();

        System.out.println("Enter your marks in Math:");
        mathMarks = sc.nextInt();

        System.out.println("Enter your marks in History:");
        hisMarks = sc.nextInt();

        // Call the totalMarks method to calculate the total and store it in the
        // variable 'total'
        int total = totalMarks(engMarks, socMarks, sciMarks, mathMarks, hisMarks);

        // Print the total marks
        System.out.println("Your total marks are: " + total);

        int average = averageMarks(total);

        // Print the total marks
        System.out.println("Your average marks is: " + average);

        String garde = gradeMarks(average);

        System.out.println("Your grade is: " + garde);
    }
}
