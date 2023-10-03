package rec;
import java.util.*;
public class phonenum {
    public static void main(String[] args) {
        String arr[] = {
            "","",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"  
        };
        String input = "234";
        System.out.println(phno("", input, arr, 0,0));

    }

    static List<String> phno(String stillans, String input, String arr[], int i, int j) {


        if(i >= input.length()) {
            List<String> ans = new ArrayList<>();
            ans.add(stillans);
            return ans;
        }
        if(j >= arr[input.charAt(i) - '0'].length()) {

            return new ArrayList<String>();
            
        } 

        String cur = arr[input.charAt(i)-'0'];

        String ans = stillans + cur.charAt(j);

        List<String> first, second, mainans = new ArrayList<>();

        first = phno(ans, input, arr, i+1, 0);
        second = phno(stillans, input, arr, i, j+1);
        mainans.addAll(first);
        mainans.addAll(second);
        return mainans;
    }



}
