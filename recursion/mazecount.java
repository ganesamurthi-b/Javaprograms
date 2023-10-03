//total no. of ways to reach the goal from starting point (3*3 maze)

package rec;
import java.util.*;
public class mazecount {

    public static void main(String[] args) {
        //System.out.println(count(0,0));

       // System.out.println(steps("", 0,0));

        boolean maze[][] = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
        };

        System.out.println(stepsWithRivers("", maze, 0,0));
    }
    static int count(int i, int j) {

    if(i == 2 || j == 2) {
        return 1;
    }
    int right = count(i, j+1);
    int down = count(i+1, j);

    return right+down;
}

    static List<String> steps(String stillans, int i, int j) {

        if(i==2 || j==2) {
            List<String> ans = new ArrayList<>();
            int start; 
            if(i==2) {
                for(start = j; start < 2; start++) {
                    stillans = stillans+"r";
                }
            }
            else {
                for(start = i; start<2; start++) {
                    stillans = stillans+"d";
                }
            }
            ans.add(stillans);
            return ans;
        }
        List<String> ans = new ArrayList<>();
        ans.addAll(steps(stillans+"r", i, j+1));
        ans.addAll(steps(stillans+"d", i+1, j));
        return ans;
    }

    static List<String> stepsWithRivers (String stillans, boolean[][] maze, int r, int c) {
        if(r == maze.length-1 && c == maze[0].length-1) {
            List<String> ans = new ArrayList<>();
            ans.add(stillans);
            return ans;
        }
        if(maze[r][c] == false) {
            List<String> ans = new ArrayList<>();
            return ans;
        }
        List<String> ans = new ArrayList<>();
        if(r < maze.length-1) {
             ans.addAll(stepsWithRivers(stillans + 'D', maze, r+1, c));
        }
        if(c < maze[0].length-1) {
            ans.addAll(stepsWithRivers(stillans + 'R', maze, r, c+1));
        }
        return ans;
        
    }  


}


