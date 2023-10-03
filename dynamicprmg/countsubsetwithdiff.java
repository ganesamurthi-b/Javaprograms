//dp - 18 count number of subsets with difference
package dp;
import java.util.*;
public class countsubsetwithdiff {
    public static void main(String[] args) {
        int arr[] = {3,2,2,5,1}, diff = 1, sum=0;
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
        }
        int dp[][] = new int[arr.length][sum+1];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], 0);
        sol(arr, diff, dp, sum);
    }

    static int sol(int[] arr, int diff, int[][] dp, int target) {

        int i, j, pick, skip;

        for(i=0; i<arr.length; i++) {
            dp[i][0] = 1;
        }
        dp[0][arr[0]] = 1;

        for(i=1; i<arr.length; i++) {
            for(j=1; j<=target; j++) {
                pick = skip = 0;
                skip = dp[i-1][j];
                if(j>=arr[i]) pick = dp[i-1][j-arr[i]];
                dp[i][j] = pick+skip;
            }
        }

        for(i=0; i<arr.length; i++) System.out.println(Arrays.toString(dp[i])); 
        return 0;
    }
}
