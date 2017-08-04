import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> teach = new HashMap<String, String>();
        teach.put("Tom", "CoreJava");
        teach.put("John", "Oracle");
        teach.put("Susan", "Oracle");
        teach.put("Jerry", "JDBC");
        teach.put("Jim", "Unix");

        //增加一位新老师Allen 教JDBC
        teach.put("Allen", "JDBC");

        //Susan 改为教CoreJava
        teach.put("Susan","CoreJava");

        //遍历Map，输出所有的老师及老师教授的课程
        Set<Entry<String, String>> set = teach.entrySet();
        Iterator<Entry<String, String>> it = set.iterator();
        while(it.hasNext()){
            Entry<String, String> e = it.next();
            System.out.println(e.getKey()+" "+e.getValue());
        }

        //从map中得到Jim教授的课程并打印到控制台
        String course = teach.get("Jim");
        System.out.println("Jim老师教的课程是"+course);
        //用Map输出所有教Oracle 的老师
        Set s2 = teach.keySet();// 将map的key赋给s2
        // 利用迭代器遍历
        Iterator it4 = s2.iterator();
        while (it4.hasNext()) {
            Object key = it4.next();
            // map.get(value):表示map中的值
            if (teach.get(key).equals("CoreJava"))
                System.out.println(key + " 教 " + teach.get(key));
        }
    }

}

