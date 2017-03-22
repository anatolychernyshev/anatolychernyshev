import java.util.Scanner;

public class taskone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = 0;
        for (int i=1; i<3; i++){
        System.out.print("������� "+i+"-�� �����: ");
        int a = in.nextInt();
        b = b + a;
        }
        System.out.println("����� �����: "+b);
        
    }
    
}
