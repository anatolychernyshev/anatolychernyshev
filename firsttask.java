import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class firsttask {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = 0;
        for (int i=0; i<2; i++) {
            if (i == 0)  System.out.print("First number: ");
            else  System.out.print("Second number : ");
            int a = Integer.parseInt(br.readLine());
            b += a;
        }
        System.out.println("Sum of numbers: "+b);

    }
}
