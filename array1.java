import java.util.*;

class array1 {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));

        int c[] = Arrays.copyOf(a, a.length);
         System.out.println("Copy using Arrays.copyOf():");
        System.out.println(Arrays.toString(c));

        // 🔹 3. Copy using System.arraycopy()
        int d[] = new int[a.length];
        System.arraycopy(a, 0, d, 0, a.length);
         System.out.println("Copy using System.arraycopy():");
        System.out.println(Arrays.toString(d));

        // 🔹 4. Copy using clone()
        int e[] = a.clone();
        System.out.println("Copy using clone():");
        System.out.println(Arrays.toString(e));
        

    }

    
    
}