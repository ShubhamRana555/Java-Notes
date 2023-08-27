public class patterns {
    public static void main(String args[]){
        
    /* 
    System.out.print("enter the size of pattern : ");
    int n = sc.nextInt();
    for(int i=1;i<=n;i++){                                //  *
        for(int j=1;j<=i;j++){                            //  **
            System.out.print("*");                        //  ***
        }                                                 //  ****
        System.out.println();

    }
    */
    /* 
    System.out.print("enter the size of pattern : ");
    int n = sc.nextInt();
    for(int i=n;i>=1;i--){                                  //  ****
        for(int j=1;j<=i;j++){                              //  ***
            System.out.print("*");                          //  **
        }                                                   //  *
        System.out.println();
    }  */
    
    //hollowRectangle(5,4);
    //inverted_rotated_half_pyramid(7);
    //zero_one_triangle(5);
    //number_pyramid(6);
    //butterfly(6);
    //solid_rhombus(6);
    //hollow_rhombus(8);
    diamond(7);
}           

    
    public static void hollowRectangle(int totRows, int totCols){
        for(int i=1;i<=totRows;i++){
            for(int j=1;j<=totCols;j++){
                if(i==1 || i==totRows || j==1 || j==totCols){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void inverted_rotated_half_pyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    } 
    
    public static void number_pyramid(int n){
        for(int i=1;i<=n;i++){
            //Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //Numbers
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void butterfly(int n){
        // 1st HALF
        for(int i=1;i<=n;i++){
            //Stars - i
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            //Spaces - 2*(n-i)
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            //Stars - i
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //2nd HALF
        for(int i=n;i>=1;i--){
            //Stars - i
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            //Spaces - 2*(n-i)
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            //Stars - i
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n){
        for(int i=1;i<=n;i++){
            //Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //Stars
            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n){
        for(int i=1;i<=n;i++){
            //Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            
            System.out.println();
        }
    }
    

    public static void diamond(int n){
        //1st HALF
        for(int i=1;i<=n;i++){
            //Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            //Stars
            for(int j=1;j<=(2*i)-1;j++){  // (2*i)-1 ----> FOR ODD OCCURENCE OF STARS
                System.out.print("* ");
            }
            System.out.println();
        }

        //2nd HALF
        for(int i=n;i>=1;i--){
            //Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            //Stars
            for(int j=1;j<=(2*i)-1;j++){  // (2*i)-1 ----> FOR ODD OCCURENCE OF STARS
                System.out.print("* ");
            }
            System.out.println();
        }
    }



}   































