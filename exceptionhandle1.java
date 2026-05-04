class exceptionhandle1 {
    public static void main(String[] args) {
    // int arr[]  = {1,2,3,4,5};
    // try {
    //     System.out.println(arr[10]);
    // } 
    // catch (ArrayIndexOutOfBoundsException e) {
    //     System.out.println("Array index is out of bounds. Please check the index and try again.");
    // }
    // String str = null;
    // try {
    //     System.out.println(str.length());
    // } 
    // catch (NullPointerException e) {
    //     System.out.println("Null pointer exception occurred. Please ensure the string is initialized before accessing its length.");
    // }
    // int a = 10;
    // int b = 0;
    // try {
    //     int result = a / b;
    //     System.out.println("Result: " + result);
    // } 
    // catch (ArithmeticException e) {
    //     System.out.println("Arithmetic exception occurred. Division by zero is not allowed. Please provide a non-zero divisor.");
    // }
    int arr[]  = {1,2,3,4,5};
    try{
        for(int i=0;i<=arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Array index is out of bounds. Please check the index and try again.");
    }
}
}
