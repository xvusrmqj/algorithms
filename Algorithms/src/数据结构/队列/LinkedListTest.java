package 数据结构.队列;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Java中的LinkedList实现了双端队列(DeQueue)，DeQueue也实现了队列。
 */
public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void init(){
        list = new LinkedList(Arrays.asList(1,2,3,4,5));
    }
    /**
     * 参考：https://docs.oracle.com/javase/tutorial/collections/interfaces/queue.html
     * Insert：add(e)
     * Remove：remove()
     * Examine：element()
     */
    @Test
    public void testQueue(){
        list.add(6); // enqueue
        while (!list.isEmpty()){
            Integer i = list.remove(); // dequeue
            System.out.println(i);
        }
    }
    /**
     * addFirst(e)
     * addLast(e)
     * removeFirst()
     * removeLast()
     */
    @Test
    public void testDequeue(){
        list.addFirst(0);
        list.addLast(6);
        // now the dequeue is [0,1,2,3,4,5,6]

        // removeFist 3 times
        for (int i = 0; i < 3; i++) {
            Integer integer = list.removeFirst();
            System.out.print(integer);
        }
        System.out.println();
        // removeLast 3 times
        for (int i = 0; i < 3; i++) {
            Integer integer = list.removeLast();
            System.out.print(integer);
        }
        // now the dequeue is [3]
    }
}
