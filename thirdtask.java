import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thirdtask {
    public static int recursion (int a){
        int b;
        if (a==1) return 1;
        b = recursion (a-1) * a;
        return b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number for the factorial : ");
        int a = Integer.parseInt(br.readLine());
        System.out.println(a+"! = "+recursion(a));

    }
}
