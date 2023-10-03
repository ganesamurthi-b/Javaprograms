// dp 24 rod cutting
package dp;
import java.util.*;
public class rodcutting {
    public static void main(String[] args) {
        int n = 5; int arr[]  = {2,5,7,8,10}; // wt = 0,1,2,3,4
        int dp[][] = new int[arr.length][n+1];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], -1);
        //System.out.println(dpsol(arr.length-1, n, arr, dp));

        dpsol2(arr, n, dp);

    }
    static int sol(int ind, int n, int arr[]) {
        if(ind == 0) return (n/(ind+1))*arr[ind];

        if(n == 0) return 0;

        int pick=0, skip=0;

        skip = sol(ind-1, n, arr);
        if(n >= ind+1) pick = arr[ind] + sol(ind, n-(ind+1), arr);

        return Integer.max(skip, pick);
    }

    static int dpsol(int ind, int n, int[] arr, int[][] dp) {
        if(dp[ind][n] != -1) return dp[ind][n];

        if(ind ==0) return dp[ind][n] = (n/(ind+1) * arr[ind]);

        if(n == 0) return dp[ind][n] = 0;

        int pick, skip; pick = skip = 0;
        
        skip = dpsol(ind-1, n, arr, dp);

        if(n >= ind+1) 
            pick = arr[ind] + dpsol(ind, n-(ind+1), arr, dp);
         
        return dp[ind][n] = Integer.max(pick, skip);

    }

    static int dpsol2(int arr[], int n, int dp[][]) {

        int i, j, pick, skip;

        for(i=0; i<=n; i++) {
            dp[0][i] = (i/1)*arr[0];
        }

        for(i=0; i<arr.length; i++) {
            dp[i][0] = 0;
        }

        for(i=1; i<arr.length; i++) {
            for(j=1; j<=n; j++) {
                pick = skip = 0;

                skip = dp[i-1][j];

                if(j >= i+1) 
                    pick = arr[i] + dp[i][j-(i+1)];

                dp[i][j] = Integer.max(pick, skip);

            }
        }

        System.out.println(dp[arr.length-1][n]);
        return 1;
    }
}