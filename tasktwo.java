import java.util.Scanner;

public class tasktwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("������� �����, ������� ����� �������� � �������: ");
        int a = in.nextInt();
        System.out.print("������� ����������� �������: ");
        int b = in.nextInt();
        int c = 1;
        for (int i=0; i<b; i++){
        c = c*a;
        }
        System.out.println("�������� �����: "+c);
        
    }
    
}