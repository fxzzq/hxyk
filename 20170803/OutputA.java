import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class OutputA {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();  //next()返回空格前的东西

        System.out.println("string's value is : "+s);
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("d:\\a.txt"));
            bw.write(s);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
