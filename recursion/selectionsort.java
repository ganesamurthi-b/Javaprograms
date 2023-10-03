package rec;

import java.util.Arrays;

public class selectionsort {
    public static void main(String[] args) {
        int arr[] = {5,7,3,2,14,9,16,25,11,8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int arr[], int source, int dest) {
        int temp;
        temp = arr[source];
        arr[source] = arr[dest];
        arr[dest] = temp;
    }

    static void sort(int arr[]) {
        int max, i, j;
        max = 0;
        i = arr.length;
        j = 0;
        sort1(arr,i,j,arr[0],0);

    }
    static void sort1(int arr[], int i, int j, int max, int maxindex) {
        if(i==0) {
            return;
        }
        if(i > j) {
            if(max < arr[j]) {
                max = arr[j];
                maxindex = j;
            }
            sort1(arr, i, j+1, max, maxindex);
        }
        else if(i == j) {
            swap(arr, maxindex, j-1);
            sort1(arr, i-1, 0, arr[0], 0);
        }
    }
}
