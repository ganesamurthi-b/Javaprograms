package dp;
import java.util.*;

public class knapsack0by1 {
    public static void main(String[] args) {
        int arr[][] = {{3,2,5},{30,40,60}};
        int wt = 6, n = arr[0].length;
       // System.out.println(sol(n-1, wt, arr));
       int dp[][] = new int[arr[0].length][wt+1];
       for(int i=0; i<arr[0].length; i++) Arrays.fill(dp[i], 0);
       dpsol2(arr, dp, wt);
    }

    static int sol(int ind, int wt, int arr[][]) {
        if(ind == 0) {
            if(wt >= arr[0][ind] ) return arr[1][ind];
            else return 0;
        }
        if(wt == 0) return 0;
        int pick, skip;
        pick = skip = 0;
        skip = sol(ind-1, wt, arr);
        if(wt >= arr[0][ind]) 
            pick = arr[1][ind] + sol(ind-1, wt-arr[0][ind], arr);
        return Integer.max(pick, skip);
    }
  
    static int dpsol2(int arr[][], int dp[][], int wt) {

        int i, j, skip, pick;

        for(i=0; i<=wt; i++) {
            if(i < arr[0][0]) dp[0][i] = 0;
            else dp[0][i] = arr[1][0];
        }
        for(i=0; i<arr[0].length; i++) {
            dp[i][0] = 0;
        }

        for(i=1; i<arr[0].length; i++) {
            for(j=1; j<=wt; j++) {
                skip = pick = 0;
                skip = dp[i-1][j];
                if(j >= arr[0][i]) 
                    pick = arr[1][i] + dp[i-1][j-arr[0][i]];

                dp[i][j] = Integer.max(skip, pick);
            }
        }
        System.out.println(dp[arr[0].length-1][wt]);
        for(i=0; i<arr[0].length; i++) System.out.println(Arrays.toString(dp[i]));
        return 0;
    }
}
