import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class secondtask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number: ");
        int a = Integer.parseInt(br.readLine());
        System.out.print("Enter the exponent: ");
        int b = Integer.parseInt(br.readLine());
        int c = 1;
        for (int i=0; i<b; i++){
            c *= a;
        }
        System.out.println("Total number: "+c);

    }
}
