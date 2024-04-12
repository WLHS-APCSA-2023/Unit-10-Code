import java.util.Arrays;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = {4,5,1,2,3};
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        
        System.out.print("Original array: ");
        printArray(numbers);
        System.out.println();
        selectionSort(numbers);
        System.out.print("Selection sorted array: ");
        printArray(numbers);
        System.out.println();
        insertionSort(numbersCopy);
        System.out.print("Insertion sorted array: ");
        printArray(numbersCopy);
    }

    public static void selectionSort(int[] arr){
        int size = arr.length;
        for(int i = 0; i<size-1; i++){
            int lowestIndex = i;
            for(int j = i+1; j<size; j++){
                if(arr[j]<arr[lowestIndex]){
                    lowestIndex = j;
                }
            }
            //swap
            int temp = arr[lowestIndex];
            arr[lowestIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr){
        int length = arr.length;
        for(int i = 1; i<length;i++){
            int value = arr[i];
            int j = i-1;
            while((j>=0)&&(arr[j]>value)){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void printArray(int[] arr){
        for(int item:arr){
            System.out.print(item+" ");
        }
    }
}
