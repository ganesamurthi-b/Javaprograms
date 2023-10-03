package dp;
import java.util.*;
public class steps {
    public static void main(String args[]) {
        int n=5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        System.out.println(dpsol(n, dp));

    }

    static int sol(int n) {
        if(n < 0) return 0;
        
        if(n == 0) return 1;

        return sol(n-1) + sol(n-2);
    }

    static int dpsol(int n, int dp[]) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) return 1;
        if(dp[n] > -1) return dp[n];

        return dp[n] = dpsol(n-1, dp)+ dpsol(n-2, dp);

    }
}