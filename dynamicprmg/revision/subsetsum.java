import java.util.*; 
public class subsetsum {

    public static void main(String[] args) {
        int arr [] = {1,2,3,5};
        int target = 4;
        boolean ans =         sol(arr.length-1, target, arr);
        System.out.println(ans);
        boolean dp[][] = new boolean[4][target+1];
        sol2(arr, dp, target);
    }

    static boolean sol(int ind, int target, int arr[]) {

        if(ind == 0) {
            return target == arr[ind];
        }
        if(target == 0) return true;
        boolean pick, skip;
        pick = skip = false;
        
        skip = sol(ind-1, target, arr);
        if(target >= arr[ind]) pick = sol(ind-1, target-arr[ind], arr);
        return pick || skip;
    }

    static void sol2(int arr[], boolean dp[][], int target) {

        int i, j;
        boolean pick , skip;
        for(i=0; i<=target; i++) {
            dp[0][i] = (arr[0] == target);
            if(i==target) continue;
            dp[i][0] = true;
        }



        for(i=1; i<arr.length; i++) {
            for(j=1; j<=target; j++) {
                pick = skip = false;
                skip = dp[i-1][j];
                if(j >= arr[i]) pick = dp[i-1][j-arr[i]];
                dp[i][j] = pick || skip;
            }
        }

        for(i=0; i<dp.length; i++) System.out.println(Arrays.toString(dp[i]));


    }
    
}
