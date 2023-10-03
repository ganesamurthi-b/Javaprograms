package dp;
import java.util.*;
public class dummy {
    public static void main(String args[]) {

        List<Integer> l1,l2;
        l1 = new ArrayList<>();
        l2 = new ArrayList<>();
        l1.add(1);
        l2.add(1);
        l1.add(2); l2.add(2);
        Set<List<Integer>> s = new HashSet<>();
        s.add(l2);s.add(l1);
        System.out.println(s);
        
        

    }
}
