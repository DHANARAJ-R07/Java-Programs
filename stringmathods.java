import java.util.*;
class stringmathods {
    public static void main(String[] args) {
        // String str = "Dhanaraj Ramesh";
        // System.out.println(str.length());
        // System.out.println(str.toUpperCase());
        // System.out.println(str.toLowerCase());
        // System.out.println(str.charAt(0));
        // System.out.println(str.indexOf('a'));
        // System.out.println(str.lastIndexOf('a'));
        // System.out.println(str.substring(0, 6));
        // System.out.println(str.contains("Ramesh"));
        // System.out.println(str.equals("Dhanaraj Ramesh"));
        // System.out.println(str.equalsIgnoreCase("dhanaraj ramesh"));
        // System.out.println(str.replace('a', 'x'));
        // System.out.println(str.trim());
        // System.out.println(str.startsWith("D"));
        // System.out.println(str.endsWith("h"));
        // System.out.println(str.toCharArray());
        // System.out.println(str.isEmpty());
        // // System.out.println(str.isAlphanumeric());
        // System.out.println(str.isBlank());
        // System.out.println(str.strip());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your task: ");
        String string = sc.nextLine();
        samp o = new samp();
        o.todo(string);
        
    }
}
class samp{
    void todo(String s){
        if(s.isEmpty() || s.isBlank()){
            System.out.println("You haven't entered any message");
        }
        else{
            System.out.println("You have entered: " + s);
            System.err.println("Thank you for entering the task");
        }
    }
}
