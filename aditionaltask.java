import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aditionaltask {
    public static String Translit(String src){
        String [] a = {"у","е","Е","Н","х","Х","В","а","А","р","Р","о","О","с","С","Т"}; //ru
        String [] b = {"y","e","E","H","x","X","B","a","A","p","P","o","O","c","C","T"}; //en
        String result = "";
        for (int i=0; i < src.length(); i++){
            String add = src.substring(i, i+1);
            for (int j=0; j < a.length; j++){
                if (a[j].equals(add)){
                    add = b[j];
                    break;
                }
            }
            result += add;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("First string: ");
        String rus = br.readLine();
        System.out.print("Second string: ");
        String eng = br.readLine();
        rus = Translit(rus);

        if (rus.equals(eng)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
