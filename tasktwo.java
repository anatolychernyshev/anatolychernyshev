import java.util.Scanner;

public class tasktwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("¬ведите число, которое нужно возвести в степень: ");
        int a = in.nextInt();
        System.out.print("¬ведите необходимую степень: ");
        int b = in.nextInt();
        int c = 1;
        for (int i=0; i<b; i++){
        c = c*a;
        }
        System.out.println("»тоговое число: "+c);
        
    }
    
}