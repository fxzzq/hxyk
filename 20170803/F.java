import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class F {
    //代码实现文件的复制
    //源文件，与复制文件
    File srcFile,coyFile;
    //输入输出流
    InputStreamReader read;
    OutputStreamWriter write;
    public static void main(String[] args) {
        String path="f:/a/1.txt",path1="f:/b.txt";
        if(args.length>0)
        {
            path=args[0];
            path1=args[1];
        }
        try {
            new F(path, path1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public F(String path,String path1) throws IOException
    {
        //创建文件对象
        srcFile=new File(path);
        //读取字节缓存
        int i;
        //判断文件是否存在
        if(srcFile.exists())
        {
            //判断文件是否为文件夹
            if(srcFile.isFile())
            {
                //对文件进行读取
                read=new InputStreamReader(new FileInputStream(srcFile));
                coyFile=new File(path1);
                coyFile.createNewFile();
                write=new OutputStreamWriter(new FileOutputStream(coyFile));


                while((i=read.read())!=-1)
                {
                    write.write(i);
                }
                //关闭对象流
                write.close();
                read.close();
            }else
            {
                System.out.println("暂时不支持复制文件夹！");
            }
        }else
        {
            System.out.println("找不到指定路径下的文件！");
        }
    }
}
