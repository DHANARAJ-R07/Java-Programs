import java.util.*;

class ArrayOperations {
    public static void main(String[] args) {

        // 1. Create an array
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Original Array:");
        printArray(arr);

        // 2. Add an element (create new array)
        int newElement = 60;
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = newElement;

        arr = newArr; // update reference

        System.out.println("\nAfter Adding Element:");
        printArray(arr);

        // 3. Modify an element
        arr[2] = 99; // change 3rd element

        System.out.println("\nAfter Modification:");
        printArray(arr);

        // 4. Traverse the array
        System.out.println("\nTraversing using loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 5. Searching an element
        int key = 40;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("\nElement " + key + " found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nElement not found");
        }

        // 6. Sorting the array
        Arrays.sort(arr);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    // Method to print array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}