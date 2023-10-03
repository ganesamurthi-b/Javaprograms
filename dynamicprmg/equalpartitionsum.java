// dp-15 equal partition subset sum
package dp;
import java.util.*;
public class equalpartitionsum {
    public static void main(String[] args) {
        int arr[] = {2,3,3,3,4,5};
        int n = arr.length;
        int target = 0;
        
        boolean pick=false, skip=false;

        for(int i=0; i<arr.length; i++) target+=arr[i];         //to set target as total sum in array

        boolean[][] dp = new boolean[n][target+1];

        for(int i=0; i<n; i++) dp[i][0] = true;         // for all row in dp matrix set true if target == 0
        if(arr[0] <= target) dp[0][arr[0]] = true;      // if index == 0, set true to dp matrix if value in arr[0] equals to the target
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<=target; j++) {

                skip = pick = false;
                skip = dp[i-1][j];                      // for skip as recursion check previous call;

                if(arr[i] <= j) {
                    //System.out.print(j-arr[i] +" ");
                    pick = dp[i-1][j-arr[i]];                  // for pick, check previous call with reduced target with the current element
                }
                
                dp[i][j] = pick||skip;
            }
        }

        if(dp[n-1][target/2] == true)                          // 
            System.out.println(target/2);
        else 
            System.out.println("no");

    }
    static int sol(int ind, int part1, int part2, int arr[]) {
        if(ind == -1) {
            if(part1 == part2) return part1;
            else return -1;
        }
        int p1 = sol(ind-1, part1+arr[ind], part2, arr);
        int p2 = sol(ind-1, part1, part2+arr[ind], arr);
        return Integer.max(p1, p2);
    }




}