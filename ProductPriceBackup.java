class ProductPriceBackup {
    public static void main(String[] args) {

        // Step 1: Original array (product prices)
        int prices[] = {100, 250, 75, 300, 150};

        // Step 2: Create new array for copy
        int backup[] = new int[prices.length];

        // Step 3: Manual copy using loop
        for (int i = 0; i < prices.length; i++) {
            backup[i] = prices[i];
        }

        // Step 4: Display copied array
        System.out.println("Copied Product Prices:");
        for (int i = 0; i < backup.length; i++) {
            System.out.print(backup[i] + " ");
        }
    }
}