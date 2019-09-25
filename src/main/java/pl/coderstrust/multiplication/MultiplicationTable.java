package pl.coderstrust.multiplication;
import java.util.Scanner;

public class MultiplicationTable {

    private static int[][] multiplicationTable;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.print("Podaj wielkosc tabeli (max 12): ");
            input = sc.nextInt();
        } while(input > 12);

        sc.close();
        multiplicationTable = makeArray(input);
        printMultiplicationTable(input);

    }

    private static int[][] makeArray(int size){

        int[][] arr = new int[size + 1][size + 1];

        for(int i = 1 ; i <= size ; i++){
            arr[0][i] = i;
            arr[i][0] = i;
        }

        for(int i = 1; i <= size ; i++){
            for(int y = 1 ; y <= size ; y++){
                arr[i][y] = arr[0][y] * arr[i][0];
            }
        }

        return arr;
    }

    private static void printMultiplicationTable(int size){

        for(int i = 0 ; i <= size ; i++){
            for(int y = 0 ; y <= size ; y++){
                if(i == 0 && y == 0){
                    System.out.printf("%5s", "");
                    continue;
                }
                System.out.printf("%5d", multiplicationTable[i][y]);
            }
            System.out.println();
        }
    }
}
