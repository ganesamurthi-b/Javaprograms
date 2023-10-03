package rec;
import java.util.*;
public class subsetarr {
    public static void main(String[] args) {
        
        List<List<Integer>> ans;

        int arr[] = {1,2,3};

        //System.out.println(subset(arr, 0, new ArrayList<Integer>()));

        System.out.println(subsett(new ArrayList<Integer>(), arr, 0));

    }

    static List<List<Integer>> subset (int arr[], int i, List<Integer>ans) {
        if(i >= arr.length) {

            List<List<Integer>> a = new ArrayList<>();
            a.add(ans);
            return a;
        }

        List<Integer> l,r; l = new ArrayList<>(null); r = new ArrayList<>();

        List<List<Integer>> left, right;

        

        l.add(arr[i]);

        left = subset(arr, i+1, l);
        right = subset(arr, i+1, r);

        left.addAll(right);

        return left;
    }



    static List<List<Integer>> subsett(List<Integer> p_an, int arr[], int i) {

        if(i >= arr.length)  {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(p_an);
            return ans;
        }

        List<Integer> cur = new ArrayList<>();
        cur.addAll(p_an);
        cur.add(arr[i]);

        List<List<Integer>> left = subsett(cur, arr, i+1);
        List<List<Integer>> right = subsett(p_an, arr, i+1);

        left.addAll(right);
        return left;
    }












}

