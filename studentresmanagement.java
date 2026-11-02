
import java.util.Scanner;


class Student {

 
    private int rollNo;
    private String name;
    private int[] marks;

  
    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

   
    public int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    
    public double calculatePercentage() {
        return (double) calculateTotal() / marks.length;
    }

    
    public String calculateGrade() {
        double percentage = calculatePercentage();

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    
    public String getResult() {
        for (int mark : marks) {
            if (mark < 35) {
                return "FAIL";
            }
        }

        return "PASS";
    }

    
    public void displayResult() {
        System.out.println("\n----- STUDENT RESULT -----");

        System.out.println("Roll Number: " + rollNo);
        System.out.println("Student Name: " + name);

        System.out.println("Subject Marks:");

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }

        System.out.println("Total Marks: " + calculateTotal());
        System.out.println("Percentage: " + calculatePercentage() + "%");
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Final Result: " + getResult());
    }

  
    public int getRollNo() {
        return rollNo;
    }
}



public class studentresmanagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

    
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[5];

            for (int j = 0; j < 5; j++) {
                System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }

            students[i] = new Student(rollNo, name, marks);
        }

     
        System.out.println("\n========== ALL STUDENT RESULTS ==========");

        for (int i = 0; i < n; i++) {
            students[i].displayResult();
        }

       
        System.out.print("\nEnter Roll Number to search result: ");
        int searchRoll = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (students[i].getRollNo() == searchRoll) {
                students[i].displayResult();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }

        sc.close();
    }
}
