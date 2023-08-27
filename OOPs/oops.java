import java.util.*;
/*public class oops {
     
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BankAccount myAcc = new BankAccount(); // "myAcc" is created as object
    myAcc.name = "Shubham";
    //myAcc.password = "hello";  ---->  We cannot change  a variable with type "private" in any other class than it's original one
    myAcc.setPassword("hello");
    System.out.println(myAcc.name);                                                                       
    //System.out.print(myAcc.password);  ------>  We can't access password here , we can only modify it using function

}
}

class BankAccount{
    public String  name;
    private String password;
    public void setPassword(String pwd){
        password = pwd;
    }

    */

    //  ***************************  COPY CONSTRUCTOR  ***********************************************************
/* 
    public class oops{
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "shubham";
        s1.roll = 60;
        s1.marks[0]  = 100;  s1.marks[1] = 90;  s1.marks[2] = 80;  
        Student s2 = new Student(s1);  // Copying all properties of s1 into s2 by copy constructing
        s2.password = "xyz";
        s1.marks[2] = 50;
        
        System.out.println("printing marks of object s2 : ");
        for(int i=0;i<3;i++){
            System.out.print(s2.marks[i] + "  ");
        }
    }
    
}

class Student{
    String  name;
    int roll;
    String password;
    int marks[];

    Student(){
        marks = new int[3];
        System.out.println("Constructor is called");
    }
    
    // *********************  SHALLOW CONSTRUCTOR  *********************************************
    // Student (Student s1){
    //     marks = new int[3];  // It is important to initialise it in every constructor
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;
        
    // }

    //  ********************  DEEP CONSTRUCTOR  ***************************************************
    Student (Student s1){
        marks = new int[3];  // It is important to initialise it in every constructor
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i] = s1.marks[i];
        }
    }
    Student (String name){
        marks = new int[3];
        this.name = name;
    }
    Student(int roll){
        marks = new int[3];
        this.roll = roll;
    }


}
*/


//  MULTI-LEVEL INHERITANCE
/* 
public class oops{
    public static void main(String[] args) {
        Cat lucy = new Cat();
        lucy.breed = "indian";
        lucy.eat();
        System.out.println(lucy.breed);
    }
}

class Animal{
    String color;
    void eat(){
        System.out.println("eats.......");
    }    
    void breathe(){
        System.out.println("breathes.....");
    }

}

class Mammal extends Animal{
    int legs;
}

class Cat extends Mammal{
    String breed;
}

*/


//  *****************************************  ABSTRACT CLASSES  **********************************************
// Abstraction may not be 100% in Abstract classes
/* 
public class oops{
    public static void main(String[] args) {
        Mustang myHorse = new Mustang();
        myHorse.changeColor();
        System.out.println(myHorse.color);

    }
}

abstract class Animal{ // It may have abstract methods or non - abstract methods
    String color;
    void eat(){
        System.out.println("eats something");
    }
    Animal(){   // Constructor to give default color
        color = "brown";
    }
    abstract void walk(); // We defined here function only(not implementation) . The implementation of it is mandatory for it's child classes now 

}

class Horse extends Animal{
    void walk(){
        System.out.println("horse walks on 4 legs");
    }
    void changeColor(){
        color = "dark - brown";
    }
    Horse(){
        System.out.println("horse constructor is called ....");
    }
}
//  HIERARCHY OF CONSTRUCTOR CALLED IS : 
// *********  Animal class  -->  Horse class -->  Mustang class
class Mustang extends Horse{ 
    Mustang(){
        System.out.println("Mustang constructor is called ....");
    }
}
*/

// **********************************  INTERFACES  *********************************************************
// Abstraction is 100% in Interfaces
/* 
public class oops{
    public static void main(String[] args) {
        Queen obj1 = new Queen();
        obj1.moves();
    }
}

interface chessPlayer{
    void moves();  // Only created not implemented
}

class Queen implements chessPlayer{
    public void moves(){
        System.out.println(" moves in up , down , left , right , diagonal direction ....");
    }
}

class King implements chessPlayer{
    public void moves(){
        System.out.println("moves in all directions by one step");
    }
}
*/

// ***********************  STATIC KEYWORD IN JAVA ************************************************

public class oops{
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName = "GIS";
        System.out.println(s1.schoolName + " .....");

        Student s2 = new Student();
        System.out.println(s2.schoolName + " ....."); //Even without initialising schoolName  s2 , we got name of school which is same for all objects
    }
}
class Student{
    String name;
    int roll;
    static String schoolName;  // School name is same for every object
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }

    static int returnPercentage(int math , int phy , int chem){
        return (math + phy + chem)/3 ;
    }
}

