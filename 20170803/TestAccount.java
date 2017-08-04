

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAccount {

    public static void main(String[] args) {

        List<Account> list = new ArrayList<>();

        list.add(new Account(10.00, "1234"));
        list.add(new Account(15.00, "5678"));
        list.add(new Account(0, "1010"));


        Map<Long,Account> m1 = new HashMap<>();
        m1.put((long) 0, list.get(0));
        m1.put((long) 1, list.get(1));
        m1.put((long) 2, list.get(2));

        for(Long k:m1.keySet())                //遍历
        {
            System.out.println("id="+k+" "+"balance="+m1.get(k).getBalance());
        }


    }

}