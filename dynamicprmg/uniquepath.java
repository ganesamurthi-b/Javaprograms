package dp;
import java.util.*;
public class uniquepath {
    public static void main(String args[]) {
        int[][] dp = new int[3][3];
        for(int i=0; i<3; i++) Arrays.fill(dp[i], -1);
        //System.out.println(sol(2,2));
       // System.out.println(dpsol(2,2, dp));
        //System.out.println(dpsol2(2,2, dp));
        System.out.println(dpsol3(2,2));
    }
    static int sol(int m, int n) {
        if(m == 0 && n == 0) {
            return 1;
        }
        if(m < 0 || n < 0) return 0;
        int up = sol(m-1, n);
        int left = sol(m, n-1);
        return up+left;
    }
    static int dpsol(int m, int n, int[][] dp) {
        if(m==0 && n==0) {
            return dp[m][n] = 1;
        }
        if(m < 0 || n < 0) return 0;
        int up = dpsol(m-1, n, dp); 
        int left = dpsol(m, n-1, dp);
        return dp[m][n] = up+left;
    }
    static int dpsol2(int m, int n, int[][] dp) {
        dp[0][0] = 1;
        int up, left, i, j;

        for(i=0; i<=m; i++) {
            for(j=0; j<=n; j++) {
                if(i == 0 && j == 0) continue;
                left = 0; up = 0;
                if(i>0) up = dp[i-1][j]; 
                if(j>0) left = dp[i][j-1];
                
                dp[i][j] = up+left;
            }
        }
        return dp[m][n];
    }
    static int dpsol3(int m, int n) {
        ArrayList<Integer> prev, cur;
        prev = new ArrayList<>(n+1); cur = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) {prev.add(0); cur.add(0);}
        int up=0, left=0, i, j;

        for(i=0; i<=m; i++) {
            for(j=0; j<=n; j++) {
                if(i==0 && j==0) {
                    cur.set(j,1);
                    continue;
                }
                else {
                    up=0;left=0;
                    up = prev.get(j);
                    if(j > 0) left = cur.get(j-1);
                    cur.set(j, up+left);
                }
            }
            for(int k=0; k<3; k++) {
                prev.set(k, cur.get(k));
                cur.set(k,0);
            }
        }

        System.out.println(prev);
        
        return prev.get(n-1);
    }
}