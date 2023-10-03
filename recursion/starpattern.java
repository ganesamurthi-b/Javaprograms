package rec;
public class starpattern {
    public static void main(String[] args) {
        star(4,0);
    }

    static void star(int i, int j) {
        if(i<=0) {
            return;
        }
        if(i>j) {
            System.out.print("# ");
            star(i,j+1);
        }
        else if(i==j) {
            System.out.println();
            star(i-1,0);
        }
    }
}
