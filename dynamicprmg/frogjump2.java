package dp;
import java.util.*;
public class frogjump2 {
    public static void main(String[] args) {
        int n = 6;
        int[] heights = {30,10,60,10,60,50};
        System.out.println(sol(0, n, heights));
    }

    static int sol(int index, int n, int[] height) {

        int i, diff, tempans = Integer.MAX_VALUE, ans;

        if(index == height.length-1) {
            return 0;
        }
        if(index >= height.length) {
            return Integer.MAX_VALUE;
        }
        for(i = index+1; i<height.length; i++) {
            diff = Math.abs(height[index] - height[i]);
            ans = sol(i, n, height)+diff;

            tempans = Math.min(tempans, ans);
        }
        return tempans;

    }
}
