package rec;

import java.util.ArrayList;

public class linearsearch1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,5}, target = 4;
        System.out.println(search(arr,target,0));
    }
    static ArrayList<Integer> search(int arr[], int target, int index) {
        ArrayList<Integer> s = new ArrayList<Integer>();
        ArrayList<Integer> p;
        if(index >= arr.length) {
            return s;
        }
        if(arr[index] == target) {
            s.add(index);
        }
        p = search(arr,target,index+1);
        p.addAll(s);
        return p;
    }
}
