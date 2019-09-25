package pl.coderstrust.foobar;

public class FooBar {

    public static void main(String[] args){

        for (int i=0 ; i<=100 ; i++){

            System.out.print("\n" + i + " ");

            if(i % 3 == 0){
                System.out.print("Foo");
            }
            if(i % 5 == 0){
                System.out.print("Bar");
            }
            //Można by zrobić if dla 3, else if dla 5 i jeszcze jeden dla 15, ale ten sposób wydaje się być optymalniejszy
        }
    }
}
