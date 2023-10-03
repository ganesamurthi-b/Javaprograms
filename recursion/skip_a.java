package rec;

public class skip_a {
    public static void main(String[] args) {
        String s = "baccad";
        StringBuffer st = reverse(s,0,new StringBuffer());
        StringBuffer st1 = reverse1(s,0);
        System.out.println(st1.reverse());

    }
    static StringBuffer reverse (String s, int i, StringBuffer st) {
        if(i >= s.length()) {
            return st;
        }
        if(s.charAt(i) == 'a'){
            return reverse(s,i+1, st);
        }
        st.append(s.charAt(i));
        return reverse(s, i+1, st);
    }

    static StringBuffer reverse1(String s, int i) {
        if(i>= s.length()) {
            return new StringBuffer();
        }
        StringBuffer ans = reverse1(s,i+1);
        if(s.charAt(i) == 'a') {
            return ans;
        }
        return ans.append(s.charAt(i));

    }
}
