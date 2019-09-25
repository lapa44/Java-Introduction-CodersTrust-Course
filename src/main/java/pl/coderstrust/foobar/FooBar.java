package pl.coderstrust.foobar;

class FooBar {

    public static void main(String[] args) {
        printFooBar(100);
    }

    public static void printFooBar(int number) {
        for (int i=0 ; i<=number ; i++) {
            System.out.print("\n" + i + " ");
            if (i % 3 == 0) {
                System.out.print("Foo");
            }
            if (i % 5 == 0) {
                System.out.print("Bar");
            }
        }
    }
}
