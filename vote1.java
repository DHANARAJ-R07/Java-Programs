
import java.util.Scanner;

class vote1 {
    public static void main(String[] args) {
        System.out.println("Enter your age: ");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        checkVote cv = new checkVote();
        cv.check(age);
        


        
    }
}
class checkVote {
    void check(int age) {
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
            
        } else {
            throw new NotEligibleException("You are not eligible to vote.");        }
    }
}
class NotEligibleException extends RuntimeException {
    NotEligibleException(String message) {
        super(message);
    }
}