// dp 20 count min coins required to get target
package dp;
import java.util.*;
public class minimumcoins {
    public static void main(String[] args) {
        int arr[] = {9,6,5,1};
        int tar = 11;
        System.out.println(sol(0, arr, tar, 0));
        System.out.println(sol2(arr.length-1, tar, arr));


        int[][] dp = new int[arr.length][tar+1];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], -1);


        System.out.println(dpsol(arr.length-1, tar, arr, dp));
    }


    static int sol(int sans, int arr[], int tar, int ans) {
        
        if(sans == tar) return ans;
        int i, min = Integer.MAX_VALUE, tempans;
        for(i=0; i<arr.length; i++) {

            if(sans + arr[i] <= tar) {
                tempans = sol(sans+arr[i], arr, tar, ans+1 );
                min = Integer.min(tempans, min);
            }
        }
        return min;
    }

    static int sol2(int ind, int target, int arr[]) {

        
        if(ind == 0) {
            if(target % arr[0] == 0) 
                return target/arr[0];
            else 
                return Integer.MAX_VALUE-target;
        }
        if(target == 0) return 0;

        int skip, pick; skip = pick = Integer.MAX_VALUE;

        skip = sol2(ind-1, target, arr);
        if(arr[ind] <= target) pick = 1 + sol2(ind, target-arr[ind], arr);

        return Integer.min(pick, skip);
    }

    static int dpsol(int ind, int target, int arr[], int[][] dp) {

        if(dp[ind][target] != -1) return dp[ind][target];
        if(ind == 0){
            if(target % arr[ind] == 0) return dp[ind][target] = target/arr[ind];
            else return Integer.MAX_VALUE-target;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
        }

        if(target == 0) return dp[ind][target] = 0;

        int skip, pick;
        skip = pick = Integer.MAX_VALUE;
        
        skip = dpsol(ind-1, target, arr, dp);

        if(target >= arr[ind])
        pick = 1+dpsol(ind, target-arr[ind], arr, dp);

        return Integer.min(skip, pick);


    }
}
