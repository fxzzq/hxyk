import java.util.Scanner;

public class register {
    public static void main(String[] arg){
        System.out.println("会员注册\n");
        System.out.println("请输入注册的用户:\n");
        Scanner username=null;
        username=new Scanner(System.in);
        String  st=null;
        st=username.next();
        char[] c=st.toCharArray();
        scannerCheck(c.length);
      System.out.println("请输入注册的密码:\n");
        Scanner password=new Scanner(System.in);
        String  stpwd=null;
        stpwd=password.next();
        char[] cpwd=stpwd.toCharArray();

        scannerCheckpwd(cpwd.length);

        System.out.println("请再次输入注册的密码:\n");
        Scanner password2=new Scanner(System.in);
        String  stpwd2=null;
        stpwd2=password2.next();
        char[] cpwd2 =stpwd2.toCharArray();
        System.out.println(stpwd+"\n");
        System.out.println(stpwd2);


        isconfirm(stpwd,stpwd2);



    }
    public static void scannerCheck(int len){

         if (len<=3){
             System.out.println("请重新输入注册的用户:\n");
             Scanner username1=null;
             username1=new Scanner(System.in);
             String  st=null;
             st=username1.next();
             char[] c=st.toCharArray();
             scannerCheck(c.length);
    }

    }

    public static void scannerCheckpwd(int len) {
        if (len <=6) {
            System.out.println("请重新输入注册的密码:\n");
            Scanner password1 = null;
            password1 = new Scanner(System.in);
            String st = null;
            st = password1.next();
            char[] c = st.toCharArray();
            scannerCheckpwd(c.length);
        }
    }

    public static void isconfirm(String c1,String c2){
         if (c1.equals(c2)){
             System.out.println("注册成功！！！\n");
         }
         else {
             System.out.println("注册失败！！！\n");
         }
    }
}
