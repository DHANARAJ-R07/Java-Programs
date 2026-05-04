class CallByValueDemo {
    public static void main(String[] args) {
        int x = 10;

        changeValue(x);

        System.out.println("After method call: " + x);
    }

    static void changeValue(int num) {
        num = 50;
        System.out.println("Inside method: " + num);
    }
}