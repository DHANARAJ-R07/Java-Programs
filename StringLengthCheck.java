import java.util.*;

class StringLengthCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String str = sc.nextLine();

        
        if (str.length() < 5) {
            System.out.println("Short");
        } else {
            System.out.println("Long");
        }
    }
} 