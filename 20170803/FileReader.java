import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class FileReader
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("E:\\c2\\sevlet\\src\\FileReader.java")));
        String info = null;
        while((info = reader.readLine()) != null)
        {
            System.out.println(info);
        }
    }
}