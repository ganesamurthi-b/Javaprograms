package dp;
import java.util.*;
public class longestcommonsubsequence {
    public static void main(String args[]) {
        int ind1, ind2;
        
        String str1 = "adebc", str2 = "dcadb";
        ind1 = str1.length(); ind2 = str2.length();
        int[][] dp = new int[ind1][ind2];
        int ans = sol(ind1-1, ind2-1, str1, str2);
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], 0);
        System.out.println(ans);
        ans = dpsol(str1, str2, dp);
        //System.out.println(ans);
    }
    static int sol(int ind1, int ind2, String s1, String s2) {

        if(ind1 < 0 || ind2 < 0) return 0;
        
        if(s1.charAt(ind1) == s2.charAt(ind2)) 
            return 1+ sol(ind1-1, ind2-1, s1, s2);
        else
            return Integer.max( sol(ind1, ind2-1, s1, s2), sol(ind1-1, ind2, s1, s2));
    
    }

    static int dpsol(String s1, String s2, int[][] dp) {
        int i, j, k=0;
        for(i=0; i<dp.length; i++) {

            if(k==1) dp[i][0] = 1;
            else if(s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = 1;
                k=1;
            }
            else dp[i][0] = 0;
        }
        k=0;
        for(i=0; i<dp.length; i++) {

            if(k==1) dp[0][i] = 1;
            else if(s1.charAt(0) == s2.charAt(i)) {
                dp[0][i] = 1;
                k=1;
            }
            else dp[0][i] = 0;
        }

        for(i=1; i<dp.length; i++) {

            for(j=1; j<dp[0].length; j++) {

                if(s1.charAt(i) == s2.charAt(j))  dp[i][j] = 1+ dp[i-1][j-1];


                else dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);

            }
        }

        for(i=0; i<dp.length; i++) {
            for(j=0; j<dp[0].length; j++) System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return 1;
    }
}