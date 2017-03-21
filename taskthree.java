import java.util.Scanner;

public class taskthree {
    public static int recursion (int a){
    int b;
    if (a==1) return 1;
    b = recursion (a-1) * a;
    return b;
    
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        taskthree r = new taskthree();
        System.out.print("Введите число, у которого нужно посчитать факториал : ");
        int a = in.nextInt();
        System.out.println(a+"! = "+r.recursion(a));
        
        }
    }