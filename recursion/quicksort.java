package rec;
import java.util.*;
public class quicksort {
    public static void main(String[] args) {
        int arr[] = {10,80,30,90,40,70,50};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    static void sort(int arr[], int start, int end) {

        if(start >= end || start < 0 || end > arr.length) {
            return;
        }

        int pivot = pivindex(arr, start, end);
        System.out.println(pivot);

         sort(arr, start, pivot-1);
         sort(arr, pivot+1, end);

    }

    static int pivindex(int arr[], int start, int end) {
        int left = start, right = end-1, pivot = arr[end];

        while(left < right) {
            if(arr[left] <= pivot ) {
                left ++;
            }
            else if(arr[left] > pivot) {
                while(arr[right] > pivot)
                    right--;
                swap(arr, left, right);
                left++; right--;
            }
        }
        if(arr[left] > pivot) {
            swap(arr, left, end);
        }
        return left;
    }

    static void swap(int arr[], int left, int right) {
        int temp;
        temp = arr[left];
        //System.out.println(arr[left] + " " + right);
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
