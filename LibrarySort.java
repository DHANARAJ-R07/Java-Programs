class LibrarySort {
    public static void main(String[] args) {

        // Step 1: Store book IDs
        int bookIDs[] = {45, 12, 89, 33, 7};

        // Step 2: Sorting (Bubble Sort)
        for (int i = 0; i < bookIDs.length - 1; i++) {
            for (int j = 0; j < bookIDs.length - i - 1; j++) {
                if (bookIDs[j] > bookIDs[j + 1]) {
                    // Swap
                    int temp = bookIDs[j];
                    bookIDs[j] = bookIDs[j + 1];
                    bookIDs[j + 1] = temp;
                }
            }
        }

        // Step 3: Display sorted IDs
        System.out.println("Sorted Book IDs:");
        for (int i = 0; i < bookIDs.length; i++) {
            System.out.print(bookIDs[i] + " ");
        }
    }
}