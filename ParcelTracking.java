class ParcelTracking {
    public static void main(String[] args) {

        // Step 1: Create array
        String[] parcels = new String[5];

        // Step 2: Add values
        parcels[0] = "TRK1001";
        parcels[1] = "TRK1002";
        parcels[2] = "TRK1003";
        parcels[3] = "TRK1004";
        parcels[4] = "TRK1005";

        // Step 3: Modify one value (correcting parcel number)
        parcels[2] = "TRK9999"; // corrected value

        // Step 4: Display using loop
        System.out.println("Parcel Tracking Numbers:");
        for(int i = 0; i < parcels.length; i++) {
            System.out.println(parcels[i]);
        }
    }
}