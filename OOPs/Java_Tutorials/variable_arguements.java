
public class variable_arguements {
    // variable arguements are used to make our code scalable and prevent it from making multiple overloading functoins for different parameters. It is used to give any number of paremeters to our function.
    
    static int sum(int ...arr){
        int result = 0;
        for(int i:arr){
            result += i;
        }
        return result;
    }

    static int sum1(int x,int ...arr){ // In this function, one parameter is compulsory to take.
        int result = x;
        for(int i:arr){
            result += i;
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        // System.out.println(sum(3,4,3,4,5,6)); o/p : 25
        // System.out.println(sum());  --> o/p : 0
        
        
        // System.out.println(sum1());  --> error : found: no arguments / reason: actual and formal argument lists differ in length . Atleast one parameter should be present according to function defination.

        System.out.println(sum1(4));   
        // o/p : 4
    }
}
