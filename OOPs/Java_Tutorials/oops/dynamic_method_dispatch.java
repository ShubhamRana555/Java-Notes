
public class dynamic_method_dispatch {
    
    public static void main(String[] args) {
        Male male = new Male();   
        // male.func();  
        Human obj = new Male();  // dynamic method dispatch
        System.out.println(obj.name);
    }
    }


class Human{
    String name = "shubham";
    Human(){
        System.out.println("default constructor");
        name  = "shubh";
    }
    Human(String name){
        this.name = name;
    }

}
class Male extends Human{
    int age = 90;
    public void func(){
        System.out.println("name is : " + name);
        System.out.println("age is : " + age);
    }
}
