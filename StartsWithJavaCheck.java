import java.util.*;

class StartsWithJavaCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (str.startsWith("Java")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}