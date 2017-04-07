class grade {
    public static void main(String[] args) {

        int marks = Integer.parseInt(args[0]);
        char grade;

        if (marks >= 90) {
            grade = 'O';
        } else if (marks >= 80) {
            grade = 'A';
        } else if (marks >= 70) {
            grade = 'B';
        } else if (marks >= 60) {
            grade = 'C';
        } else if (marks >= 50) {
            grade = 'D';
        } else if (marks >= 40) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
    }
}