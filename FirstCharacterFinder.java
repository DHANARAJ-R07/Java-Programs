import java.util.*;

class FirstCharacterFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        String str = sc.nextLine();

        // Print first character
        System.out.println(str.charAt(0));
    }
}