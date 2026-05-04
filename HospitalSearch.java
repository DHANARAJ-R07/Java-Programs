import java.util.Scanner;

class HospitalSearch {
    public static void main(String[] args) {

        // Step 1: Store patient IDs
        int patientIDs[] = {101, 102, 103, 104, 105};

        // Step 2: Get input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID to search: ");
        int searchID = sc.nextInt();

        // Step 3: Search logic
        boolean found = false;

        for (int i = 0; i < patientIDs.length; i++) {
            if (patientIDs[i] == searchID) {
                found = true;
                break;
            }
        }

        // Step 4: Output result
        if (found) {
            System.out.println("Patient ID found. Treatment allowed.");
        } else {
            System.out.println("Patient ID not found. Treatment not allowed.");
        }
    }
}