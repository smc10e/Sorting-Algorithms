import java.util.Scanner;
import java.util.Vector;

/**
 * Created by smcampbell on 10/7/2015.
 */
public class Merge_Sort {

    public static void main(String[] args){

        Vector<Integer> array = new Vector<Integer>();
        array.add(2);
        array.add(5);
        array.add(1);
        array.add(9);
        array.add(3);
        array.add(6);
        array.add(4);
        array.add(7);
        array.add(8);

        System.out.println("Original Array");
        for(int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }

        System.out.println();
        System.out.println();

        //sets the index markers for the first, middle, and last elements of the whole array
        int first = 0, middle = ((int) Math.floor(array.size() / 2)) - 1, last = array.size()-1;
        array = split(array, first, middle, last);

        System.out.println("Sorted Array");
        for(int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }

    }

    //this function splits the given array into two smaller arrays
    public static Vector<Integer> split(Vector<Integer> array, int first, int middle , int last){
        Vector<Integer> half1;
        Vector<Integer> half2;

        //this if condition detects if the given array only contains two elements
        //if not it creates one half of the whole array and recursively splits that into smaller halves
        if(middle+1 != 1){
            half1 = new Vector<Integer>(middle+1);
            //sets flags for the first, middle and last elements of the first half of the array
            int f = first, m = ((int) Math.floor(middle / 2)), l = middle;
            //adds elements from the beginning of the given array to the middle of the array into another
            //array that is called half1
            for(int i = f; i < l+1; i++){
                half1.add(array.get(i));
            }
            //recursively splits half1 into smaller arrays and is returned the sorted array result
            half1 = split(half1, f, m, l);
        }
        //if there are only two elements in the given array, the elements are compared and placed in
        //ascending numerical order and then returned to the calling function
        else{
            if(array.get(0) > array.get(1)){
                int temp = array.get(0);
                array.set(0, array.get(1));
                array.set(1, temp);
            }
            return array;
        }

        //this if statement is used to determine if the second half contains only one element
        //if not the second half gets split into smaller arrays just like the first did above
        if(last-middle != 1){
            half2 = new Vector<Integer>(last-middle);
            int f = 0, m = ((int) Math.floor((last-(middle+1)) / 2)), l = last-(middle+1);
            for(int i = middle+1; i < last+1; i++){
                half2.add(array.get(i));
            }
            half2 = split(half2, f, m, l);
        }
        //if is the only element it gets added to its own array by itself since it is naturally in
        //ascending numerical order
        else{
            half2 = new Vector<Integer>(1);
            half2.add(array.get(last));
        }
        //once the two halves have been sorted separately they are then merged together and sorted again
        array = merge(half1, half2);

        //this returns the merged sorted array to the calling function
        return array;
    }

    //this merge function merges two halves of an array into one single array that is sorted in
    //ascending numerical order
    public static Vector<Integer> merge(Vector<Integer> half1, Vector<Integer> half2){
        Vector<Integer> array = new Vector<Integer>(half1.size()+half2.size());
        int j = 0;
        //this loop goes through the first half of the array and compares the elements to the
        //elements in the second half. Since both halves are sorted each time there is a
        //comparison one of the compared items gets placed into the sorted array and the other
        //continues on to compare to the next item in the other half.
        for(int i =0; i < half1.size(); i++){
            if(j <half2.size()) {
                if (half1.get(i) < half2.get(j)) {
                    array.add(half1.get(i));
                } else {
                    array.add(half2.get(j));
                    j++;
                    if(j >= half2.size()) {
                        array.add(half1.get(i));
                    }
                    else {
                        //if the item in the second half got added and there are still more
                        //items we continue to compare that same item in the first half
                        //against the rest. This "i--" keeps the value of the for loop
                        //on that same item
                        i--;
                    }
                }
            }
            else{
                array.add(half1.get(i));
            }
        }
        //if the for loop gets through all the items in the first half and there are still items
        //in the second half, this for loop just adds those remaining items to the array
        if(j <half2.size()){
            for(int k = j; k <half2.size(); k++){
                array.add(half2.get(k));
            }
        }

        //returns the merged sorted array;
        return array;
    }
}
