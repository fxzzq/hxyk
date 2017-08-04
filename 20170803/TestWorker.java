

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestWorker {
    public  static  void main(String[] args){
        List<Worker> list=new ArrayList<>();
        list.add(new Worker("张三",18,3000));
        list.add(new Worker("李四",25,3500));
        list.add(new Worker("王五",22,3200));


        list.add(1,new Worker("赵六",24,3300));

        list.remove(3);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println("迭代器方式");

        Iterator<Worker> it=list.iterator();
        //判断能否移动
        while(it.hasNext()){
            //移动指针到下一条数据，同事获取数据
            Worker p=it.next();
            p.work();
            System.out.println(p.toString());
        }
    }
}
