
public class abstract_classes {

    public static void main(String[] args) {
        // Human h = new Human();
        // h.environment("human");
        // h.species("human");


        concreteClass c1 = new concreteClass();  // default constructor

        A obj = new A();
        obj.meth1();
        obj.meth2();

    }
}

// abstract classes are those classes which have both abstract and non - abstract methods.
abstract class Earth{

// abstract method
    abstract void species(String type);  // every class which are inheriting this class needs to initialise this function compulsory.
    void environment(String name){
        if(name.equals("human")){
            System.out.println("river side area.....");
        }
        else{
            System.out.println("anywhere in the world .....");
        }
    }
        

}

class Human extends Earth{
    // we have to implement the species() function or make the "Human" class abstract then it will give error as shown below
    // error: Human is not abstract and does not override abstract method species() in Earth

    // Overriding species() funtion
    void species(String type){
        if(type.equals("human")){
            System.out.println("human are mammals");
        }
        else{
            System.out.println(type + " is a organism");
        }
    }
}

// CONSTRUCTORS IN JAVA

abstract class AbstractClass1{
    // we can simply leave program without making constructor becauses compiler creates a constructor by default.
    int a = 7;

    AbstractClass1(int var){
        this.a = var;
        System.out.println(this.a);
    }

}
class concreteClass extends AbstractClass1{
    concreteClass(){
        super(99);  // it is used to call constructor of it's superclass. As "AbstractClass" can't make a objects and hence can't use their constructors while object initialisation by themselves.
        
    }
}


// Multiple Inheritance in Java using Interfaces
interface i1{
    void meth1();
} 

interface i2{
    void meth2();
}

class A implements i1,i2{
    public void meth1(){
        System.out.println("this is meth1 .......");
    }
    public void meth2(){
        System.out.println("this is meth2 .......");
    }
}


