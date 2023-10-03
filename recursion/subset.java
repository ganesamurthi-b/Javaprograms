package rec;
import java.util.*;
public class subset {
    public static void main(String[] args) {
        String s = "abc";
        int arr[] = {1,2,3};
        System.out.println(subs(arr));


    }

    static ArrayList<String> sub(String p, String up) {

        if(up.length() <= 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = sub(p+ch, up.substring(1));
        ArrayList<String> right = sub(p, up.substring(1));
    
        left.addAll(right);
        return left;



    }

    static ArrayList<ArrayList<Integer>> subs(int arr[]) {
        
        int i,j;
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<Integer>());

        for(i=0; i<arr.length; i++) {

            int num = arr[i];
            int n = outer.size();
            for(j=0; j<n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(num);
                outer.add(inner); 
            }
        }
        return outer;
    }

    static List<List<Integer>> Subset(int[] arr) {
        List<List<Integer>> outer= new ArrayList<>();
        outer.add(new ArrayList<Integer>());

        for(int num : arr) {

            int n = outer.size();
            for(int i=0; i<n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);

            }
        }

        return outer;


    };
} 
