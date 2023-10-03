package dp;
import java.util.*;
public class subsetsum {
    public static void main(String args[]) {
        int arr[] = {2,5,1,4};
        int n=4, target = 4;
        int i, j; 
        boolean pick,skip;
        boolean[][] dp = new boolean[n][n+1];
        for(i=0; i<n; i++) Arrays.fill(dp[0], false);
        for(i=0; i<n; i++) dp[i][0] = true;
        dp[0][arr[0]] = true;
        for(i=1; i<n; i++) {
            for(j=1; j<=target; j++) {
                pick = false;
                skip = dp[i-1][j];
                if(j>= arr[i]) pick = dp[i-1][j-arr[i]];
                dp[i][j] = pick || skip;
            }
        }
        System.out.println(dp[n-1][target]);
    }
    static boolean sol(int ind, int target, int arr[]) {
        if(target == 0) return true;

        if(ind == 0) return arr[0] == target;

        boolean pick = false, skip = false;
        skip = sol(ind-1, target, arr);
        if(arr[ind] <= target) pick = sol(ind-1, target-arr[ind], arr);
        return pick||skip;
    }
}
