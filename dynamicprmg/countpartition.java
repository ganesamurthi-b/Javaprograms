// dp17 count subsets of arr with target k
package dp;
import java.util.*;

public class countpartition {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3};
        int target = 3;
       // System.out.println(sol(arr.length-1, target, arr));
        int dp[][] = new int[arr.length][target+1];
        for(int i=0; i<=target; i++) Arrays.fill(dp[i], -1);
        dpsol2(arr, dp, target);
        //System.out.println(dpsol(arr.length-1, target, arr, dp));
        //System.out.println(Arrays.deepToString(dp));
        
    }

    static int sol(int ind, int target, int arr[]) {
        if(target == 0) return 1; 
        if(ind == 0) {
            if( arr[0] == target ) return 1;
            else return 0;
        }
        int skip = 0, pick = 0;
        skip = sol(ind-1, target, arr);
        if(target >= arr[ind]) 
            pick = sol(ind-1, target-arr[ind], arr);
        return skip + pick;
    }

    static int dpsol(int ind, int target, int arr[], int dp[][]) {
        if(dp[ind][target] != -1) return dp[ind][target];
        if(ind == 0) {
            if(arr[0] == target) 
                return dp[ind][target] = 1;
            else 
                return dp[ind][target] = 0;
        }
        if(target == 0) return dp[ind][target ] = 1;
        int pick=0, skip=0;
        skip = dpsol(ind-1, target, arr, dp);
        if(arr[ind] <= target) pick = dpsol(ind-1, target-arr[ind], arr, dp);
        return dp[ind][target] = pick+skip;
    }

    static void dpsol2(int arr[], int dp[][], int target) {
        int i, j, pick=0, skip=0;

        for(i=0; i<=target; i++) {
            if(i == 0 || i == arr[0]) { 
                dp[0][i] = 1;
            }
            else
                dp[0][i] = 0;
        }
        for(i=0; i<arr.length; i++) dp[i][0] = 1;
        for(i=1; i<arr.length; i++) {
            for(j=1; j<=target; j++) {
                pick = skip = 0;
                skip = dp[i-1][j];
                if(j>=arr[i]) pick = dp[i-1][j-arr[i]];

                dp[i][j] = pick+skip;

            }
        }
        System.out.println(dp[arr.length-1][target]);
        System.out.println(Arrays.deepToString(dp));
    }
}
