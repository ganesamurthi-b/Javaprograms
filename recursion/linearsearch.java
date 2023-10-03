package rec;
import java.util.*;

public class linearsearch {
    public static void main(String args[]) {
        int arr[] = {1,2,3,5,5,6}, target = 5;
        ArrayList<Integer> ans = new ArrayList<Integer> ();
        System.out.println(search(arr,target,ans,0));

    }

    static ArrayList<Integer> search(int arr[], int target, ArrayList<Integer> ans,int index) {
        if(index >= arr.length) {
            return ans;
        }
        if(arr[index] == target) {
            ans.add(index);
        }
        return search(arr,target,ans,index+1);
    }
}