package test;

public class Nine {

    public static void main(String[] args) {


        for (int i = 1; i < 10; i++) {


            for (int j = 1; j < 10; j++) {

                if (i % 2 != 0){
                    System.out.println(i + " * " + j + " = " + (j * i));
                }

            }

        }


    }//end of main
}//end of public class
