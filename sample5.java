class sample5 {
    static int m = 20;
    public static void main(String[] args) {
        samp o = new samp();
        o.add();
        System.out.println(m);
        // System.out.println(o.a);
        // System.out.println(samp.b);
    }
}

class samp {
    int a = 20;
    static int b = 30;

    void add() {
       final int a = 10;
        

        System.out.println(a);
        
    }
}