package 数据结构.树.二叉树;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 前中后序遍历都相当于图的深度优先搜索
 * 层次遍历相当于图的广度优先搜索
 */
public class 遍历 {
    // 前序遍历
    public static void preOrderTraverse(Node node){
        if(node!=null){
            System.out.print(node.val);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }
    // 前序遍历
    public static void preOrderTraverseNonRecursion(Node node){
        Stack<Node> stack = new Stack<>();
        // todo
    }
    // 中序遍历
    public static void inOrderTraverse(Node node){
        if(node!=null){
            inOrderTraverse(node.left);
            System.out.print(node.val);
            inOrderTraverse(node.right);
        }
    }
    // 后序遍历
    public static void postOrderTraverse(Node node){
        if(node!=null){
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.val);
        }
    }

    public static void traverseByLayer(Node node){
        LinkedList<Node> queue = new LinkedList<>();
        // todo

    }
    public static void main(String[] args) {
        System.out.println("=======test create tree========");
        Node tree1 = Node.init(new int[]{});
        Node tree2 = Node.init(new int[]{1});
        Node tree3 = Node.init(new int[]{1, 2});
        Node tree4 = Node.init(new int[]{1, 2, 3});
        Node tree5 = Node.init(new int[]{1, 2, 3, -1, 4});
        Node tree6 = Node.init(new int[]{1, 2, 3, 4, -1});
        System.out.println("=======traverse========");
        preOrderTraverse(tree6);
        System.out.println();
        inOrderTraverse(tree6);
        System.out.println();
        postOrderTraverse(tree6);
    }

}
