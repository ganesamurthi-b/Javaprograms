package rec;
public class starpattern2 {
    public static void main(String[] args) {
        print(4,0);
    }
    

    static void print(int i, int j) {
        if(i<=0)    return;

        if(i > j) {
            print(i,j+1);
            System.out.print("$ ");
        }
        else if(i == j) {
            print(i-1, 0);
            System.out.println();        }
    }
}
