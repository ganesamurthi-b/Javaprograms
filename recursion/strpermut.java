package rec;
import java.util.*;
public class strpermut {
    public static void main(String args[]) {

        String str = "abcd";
        String p = "";
        //System.out.println( perm (p, str, 0));
        //System.out.println(p.charAt(0));
        System.out.println(count("","abc"));
        
    }



    static List<String> perm(String p, String up, int i) {

        if(up.length() == 0) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        List<String> ans = new ArrayList<>(), tempans;
        
        int index; String temp="";
        for(index=0; index<=p.length(); index++) {
            
            tempans = perm(temp+ch+p.substring(index), up.substring(1), i);
            ans.addAll(tempans);
            if((p.equals(""))  || index == p.length()){
                continue;
            }
            else {
                temp = temp.concat(p.charAt(index)+"");
            }


        }

        return ans;

    }

    static int count(String p, String up) {
        if(up.isEmpty()) {
            return 1;
        }
        int i, count=0;
        char ch = up.charAt(0);
        for(i=0; i<=p.length(); i++) {

            count+= count(p.substring(0,i) + ch + p.substring(i,p.length()), up.substring(1));

        }
        return count;
    }

}
