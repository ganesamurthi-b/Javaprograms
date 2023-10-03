// dp 22 count total ways to make target 

package dp;
import java.util.*;
public class countcoins {
    public static void main(String[] args) {
        int arr[] = {1,2,3}, target = 11;
        int[][] dp = new int[arr.length][target+1];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], 0);
        
        System.out.println(sol(arr.length-1, target, arr));

        dpsol2(arr, dp, target);

    }
    static int sol(int ind, int target, int arr[]) {
        if(ind == 0) {
            if(target % arr[ind] == 0) return 1;
            else return 0;
        }
        if(target == 0) return 1;

        int pick=0, skip=0;
        skip = sol(ind-1, target, arr);
        if(target >= arr[ind])
            pick  = sol(ind, target-arr[ind], arr);
        return skip+pick;
        
    }

    static int dpsol2(int arr[], int dp[][], int target) {
        int i, j, pick=0, skip=0;

        
        for(i=0; i<=target; i++) {
            if(i % arr[0] == 0) dp[0][i] = 1;
        }

        for(i=0; i<arr.length; i++) dp[i][0] = 1;

        dp[0][0] = 1;

        
        for(i=1; i<arr.length; i++) {
            for(j=1; j<=target; j++) {
                skip = pick = 0;
                skip = dp[i-1][j];
                if(j >= arr[i]) pick = dp[i][j-arr[i]];
                dp[i][j] = pick+skip;
            }
        }

        for(i=0; i<arr.length; i++) System.out.println(Arrays.toString(dp[i]));
        return 0;
    }
}
