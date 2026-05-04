import java.util.ArrayList;
import java.util.Collections;
class arraylist1 {
    public static void main(String args[]){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(77);
        arr.add(81);
        arr.add(96);
        System.out.println(arr);
        arr.set(1,100);
        arr.set(0,200);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);

    }
    
}
