package 互联网公司.其它;

public class 数组单调和 {

	public static void main(String[] args) {

	}
    public static int calcMonoSum(int[] A, int n) {
        // write code here
    	if(A==null||A.length==0) return 0;
    	
    	int arr[]  = new int[A.length];

        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < i; j++) {
				if(A[j]<A[i]){
					arr[i] += A[j];
				}
			}
		}
        for (int i = 0; i < arr.length; i++) {
			
		}
        return 0;
    }
}
