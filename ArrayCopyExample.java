import java.util.Arrays;

class ArrayCopyExample {
    public static void main(String[] args) {

        // Step 1: Original array
        int original[] = {10, 20, 30, 40, 50};

        // Method 1: clone()
        int copy1[] = original.clone();

        // Method 2: Arrays.copyOf()
        int copy2[] = Arrays.copyOf(original, original.length);

        // Method 3: System.arraycopy()
        int copy3[] = new int[original.length];
        System.arraycopy(original, 0, copy3, 0, original.length);

        // Display results
        System.out.println("Original Array: " + Arrays.toString(original));
        System.out.println("Clone Copy: " + Arrays.toString(copy1));
        System.out.println("Arrays.copyOf(): " + Arrays.toString(copy2));
        System.out.println("System.arraycopy(): " + Arrays.toString(copy3));
    }
}