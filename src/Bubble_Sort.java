import java.util.Scanner;
import java.util.Vector;

/**
 * Created by smcampbell on 10/7/2015.
 */
public class Bubble_Sort {

    public static void main(String[] args){

        int array [] = new int[5];
        int temp;
        boolean swap = true;
        int length = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bubble Sort");
        System.out.print("Please enter 5 numbers to sort: ");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Original Array");
        for (int i = 0; i < length; i++) {
            if(i != length - 1) {
                System.out.print(array[i] + ", ");
            }
            else{
                System.out.print(array[i]);
            }
        }

        System.out.println();

        while(swap == true) {
            swap = false;
            for (int i = 0; i < length -1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
            length -= 1;
        }

        System.out.println();
        System.out.println("Sorted Array");
        for (int i = 0; i < array.length; i++) {
            if(i != array.length - 1) {
                System.out.print(array[i] + ", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
    }
}
