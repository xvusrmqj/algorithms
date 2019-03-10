package 数据结构;

public class 单链表 {
    public static void main(String[] args) {
        Node node2 = new Node(1,new Node(2,new Node(3,null)));
        System.out.println(node2);
        System.out.println(反转链表(node2));

    }
    public static void 头插法建立链表(Node node){

    }
    public static void 尾插法建立打印链表(Node node){

    }

    /**
     * 这个经常考，而且自己很难写出来，看着很简单，但是写起来很复杂，自己感觉都驾驭不了。。。
     *
     * @param node
     */
    public static Node 反转链表(Node node){
        // 这里会需要3个指针，其中两个代表从谁指向谁，另一个代表遍历的指针。
        if(node == null ||node.next == null){
            return node;
        }

        Node p = node;
        Node q = p.next;
        node = node.next;

        p.next = null;
        while (node!=null){
            node = node.next;
            q.next = p;
            p = q;
            q = node;
        }
        return p;
    }
    static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        // 打印出Node的所有节点
        @Override
        public String toString() {
            Node node = this;
            StringBuilder result = new StringBuilder();
            while (node!=null){
                result.append(node.val +"->");
                node = node.next;
            }
            return result.substring(0,result.length()-2);
        }
    }

}
