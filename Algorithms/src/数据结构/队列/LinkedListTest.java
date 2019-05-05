package 数据结构.队列;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList(Arrays.asList(1,2,3,4,5));
        while (!list.isEmpty()){
            Integer i = list.remove();
            System.out.println(i);
        }
    }
}
