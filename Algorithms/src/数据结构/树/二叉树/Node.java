package 数据结构.树.二叉树;

public class Node {
    int val;
    Node left;
    Node right;

    private Node(int val) {
        this.val = val;
    }

    /**
     * 根据数组建树
     * 假设空结点标记为-1
     */
    public static Node init(int[] arr){
        if(arr ==null || arr.length == 0){
            return null;
        }
        // create node array
        Node[] nodeArr = new Node[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=-1){
                nodeArr[i+1] = new Node(arr[i]);
            }
        }
        // connect the node
        for (int j = 2; j < nodeArr.length; j++) {
            if(j%2==0){ // left child
                nodeArr[j/2].left = nodeArr[j];
            }else{ // right child
                nodeArr[j/2].right = nodeArr[j];
            }
        }
        return nodeArr[1];
    }
}
