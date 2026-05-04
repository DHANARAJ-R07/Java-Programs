import java.util.Arrays;
import java.util.Random;

class RandomExample {
    public static void main(String[] args) {
        Random rand = new Random();

        int studentId = rand.nextInt(1000);
        double marks = rand.nextDouble() * 100;
        float attendance = rand.nextFloat() * 100;
        boolean status = rand.nextBoolean();
        long regNo = rand.nextLong();
        double performance = rand.nextGaussian() * 10;

        byte[] bytes = new byte[5];
        rand.nextBytes(bytes);

        System.out.println("Student ID: " + studentId);
        System.out.println("Marks: " + marks);
        System.out.println("Attendance: " + attendance);
        System.out.println("Status: " + (status ? "Pass" : "Fail"));
        System.out.println("Registration No: " + regNo);
        System.out.println("Performance Score: " + performance);
        System.out.println("Random Bytes: " + Arrays.toString(bytes));

        System.out.print("5 Random Numbers: ");
        rand.ints(5, 0, 100).forEach(n -> System.out.print(n + " "));
    }
}