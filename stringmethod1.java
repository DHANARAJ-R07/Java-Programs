import java.util.*;

class stringmethod1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        total o = new total();
        int r;

        do {
            System.out.println("Enter your Expenses: ");
            String expenses = sc.nextLine();

            System.out.println("Enter the rate of expenses: ");
            int rate_exp = sc.nextInt();
            sc.nextLine(); // clear buffer

            o.rate(rate_exp);

            System.out.println("Press 0 to finish bill or any other number to continue:");
            r = sc.nextInt();
            sc.nextLine(); // clear buffer

        } while (r != 0);

        o.finalBill(); // print final total after loop
    }
}

class total {
    int m = 0; // store total permanently

    void rate(int a) {
        m = m + a;
    }

    void finalBill() {
        System.out.println("Final total expenses: " + m);
    }
}