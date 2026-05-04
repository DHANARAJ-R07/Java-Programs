
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

class Stringbuilders1 {
    public static void main(String args[]) {

        String s = "abc";
        StringBuilder sb = new StringBuilder(s);

        sb.append("def"); 
        System.out.println("After append: " + sb);
        sb.replace(1, 3, "XY");
        System.out.println("After replace: " + sb);
        sb.delete(1, 3);
        System.out.println("After delete: " + sb);
        sb.insert(1, "ZZ");
        System.out.println("After insert: " + sb);
        System.out.println("Character at index 2: " + sb.charAt(2));
        System.out.println("Capacity: " + sb.capacity());

        
        StringBuffer sbf = new StringBuffer(s);
        sbf.append("def");
        System.out.println("After append: " + sbf); 
        sbf.replace(1, 3, "XY");
        System.out.println("After replace: " + sbf);
        sbf.delete(1, 3);
        System.out.println("After delete: " + sbf);
        sbf.insert(1, "ZZ");
        System.out.println("After insert: " + sbf);
        System.out.println("Character at index 2: " + sbf.charAt(2));
        System.out.println("Capacity: " + sbf.capacity());


        byte b[] = new byte[5];
        Random r = new Random();
        r.nextBytes(b);
        System.out.println(Arrays.toString(b));
        

    }
}