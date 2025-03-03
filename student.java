import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter " + name + "'s score: ");
            int score = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            students.add(new Student(name, score));
        }

        scanner.close();

        // Calculate average, highest, and lowest scores
        int totalScore = 0;
        int highestScore = Integer.MIN_VALUE;
        int lowestScore = Integer.MAX_VALUE;
        Student highestStudent = null;
        Student lowestStudent = null;

        for (Student student : students) {
            totalScore += student.getScore();
            if (student.getScore() > highestScore) {
                highestScore = student.getScore();
                highestStudent = student;
            }
            if (student.getScore() < lowestScore) {
                lowestScore = student.getScore();
                lowestStudent = student;
            }
        }

        double averageScore = (double) totalScore / numStudents;

        // Display results
        System.out.println("\nClass Statistics:");
        System.out.println("Average Score: " + averageScore);
        System.out.println("Highest Score: " + highestScore + " by " + highestStudent.getName());
        System.out.println("Lowest Score: " + lowestScore + " by " + lowestStudent.getName());
        System.out.println("\nStudent Grades:");
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getScore() + " (" + student.getGrade() + ")");
        }
    }
}
