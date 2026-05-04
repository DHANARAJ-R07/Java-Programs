
class sample7 {
    public static void main(String[] args) {
        
        constructors o =new constructors("Dhanaraj");
        constructors o2 =new constructors(o);
        constructors o3 = new constructors();

        System.out.println(o.name);
        System.out.println(o2.name);

    }
}
class constructors{
    String name;
    String name2;
    constructors(){
       System.out.println("hiiii");
    }
    constructors (String nm) {
        name = nm;
     
    }
    constructors (constructors j){
        name2 = j.name;
    }
}