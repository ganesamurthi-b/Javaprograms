//leetcode different ways to add paranthesis - 241
package rec;
import java.util.*;
public class addparanthesis {
    public static void main(String[] args) {
        String str = "2*3-4*5";
        System.out.println(addbrackets(str));
    }
    static List<Integer> addbrackets(String str) {
        if(! ( str.contains("*") || str.contains("+") || str.contains("-") ) ) {
            Integer i = Integer.valueOf(str);
            List<Integer> ans = new ArrayList<>();
            ans.add(i);
            return ans;
        }
        int i,len = str.length();
        List<Integer> mainans = new ArrayList<>();
        for(i=0; i<len; i++) {
            if(str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-') {
                List<Integer> left = addbrackets (str.substring(0,i));
                List<Integer> right = addbrackets(str.substring(i+1, len));
                List<Integer> tempans = new ArrayList<>();
                int l_size = left.size(), r_size = right.size();
                int j,k;
                if(str.charAt(i) == '*') {
                    for(j=0; j<l_size; j++) {
                        int ele = left.get(j);
                        for(k=0; k<r_size; k++) {
                            int ans = ele * right.get(k);
                            tempans.add(ans);
                        }
                    }
                }
                else if(str.charAt(i) == '+') {

                    for(j=0; j<l_size; j++) {

                        int ele = left.get(j);
                        for(k=0; k<r_size; k++) {
                            int ans = ele + right.get(k);
                            tempans.add(ans);
                        }
                    }
                }
                else if(str.charAt(i) == '-') {

                    for(j=0; j<l_size; j++) {

                        int ele = left.get(j);


                        for(k=0; k<r_size; k++) {

                            int ans = ele - right.get(k);
                            tempans.add(ans);
                        }
                    }
                }
                mainans.addAll(tempans);
            }
        }
        return mainans;
    }
}
