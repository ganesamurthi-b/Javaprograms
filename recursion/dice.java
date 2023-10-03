package rec;
import java.util.*;
public class dice {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int target = 4;

        System.out.println(subset(new ArrayList<Integer>(), 4));

    }

    static List<List<Integer>> subset(List<Integer> s_ans, int target) {

        if(target == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(s_ans);
            return ans;
        }
        int i;
        List<List<Integer>> ans = new ArrayList<>();

        for(i=1; i<=target; i++) {

            List<Integer> temp = new ArrayList<>();
            temp.addAll(s_ans);
            temp.add(i);
            ans.addAll(subset(temp, target-i));
        }
        return ans;

    }


}
