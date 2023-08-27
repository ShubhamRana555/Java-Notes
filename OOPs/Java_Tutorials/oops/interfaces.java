public class interfaces {
    public static void main(String[] args) {
        // interfaces are the abstract classes with all abstract methods.


        Player.hello();
        // if we make a function "public static void func(){}" outside the public class, we can stril run the function by using only it's class name and not using objects.
        
        Player p = new Player();
        p.pieces("queen");
        p.moves("rook");


    }
}

interface Chess{
    // interface in java does not have constructors because all data members in interfaces are public and final by default.

    int a=10;  // it cannot be changed because it is final by default
    void pieces(String name);
    void  moves(String name);
}

class Player implements Chess{
    
    public void pieces(String name){
        System.out.println(name + " is a chess piece .....");
    }
    
    public void moves(String name){
        if(name.equals("queen")){
            System.out.println(name + " --> up down bottom left .....");
        }
        else{
            System.out.println(name + " --> any moves in the chess platform .....");
        }
    }

    public static void hello(){
        System.out.println("hello");
    }
}
