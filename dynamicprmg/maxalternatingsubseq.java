// DP 5 Maximum alternating subsequence
package dp;
import java.util.*;
public class maxalternatingsubseq {
    public static void main(String args[]) {
        int arr[] = {2,1,4,9};
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(sol(0, 0, arr.length, arr)) ;
        System.out.println(sol2(0,arr.length, arr));
        System.out.println(dpsol(0, arr.length, arr, dp));
        System.out.println(dpsol2(arr));
    }

    static int sol(int sum, int index, int n, int[] arr) {

        if(index >=n ) return sum;

        int cur = arr[index];

        int pick = sol(sum+cur, index+2, n, arr);

        int skip = sol(sum, index+1, n, arr);

        return Integer.max(pick, skip);
        

    }


    
    static int sol2(int index, int n, int[] arr) {

        if(index == n-1) {
            
            return arr[index];
        }
        if(index >= n) return 0;

        int pick = arr[index] + sol2(index+2, n, arr);
        int skip = sol2(index+1, n, arr);

        return Integer.max(pick,skip);
    }



    static int dpsol(int index, int n, int arr[], int dp[]) {
        if(index == n-1) {
            
            return dp[index] = arr[index];
        }
        if(index >= n) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = arr[index] + sol2(index+2, n, arr);
        int skip = sol2(index+1, n, arr);

        return dp[index] = Integer.max(pick,skip);

        
    }



    static int dpsol2(int arr[]) {
        int  n = arr.length, i;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        dp[n-1] = arr[n-1];

        for(i = n-2; i>=0; i--) {
            
            int pick = arr[i];
            if(i+2 < n) pick += dp[i+2];
            int skip = 0+dp[i+1];

            dp[i] = Integer.max(pick, skip);

            
        }

        return dp[0];
    }
}
