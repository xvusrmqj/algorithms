package 剑指offer;

public class P38二维数组中的查找 {

	public static void main(String[] args) {

	}
	public static boolean find(int[][] arr,int target) {
		if(arr==null||arr.length==0) return false;
		// 从第0行,第N列开始
		int row = 0;
		int column = arr.length;
		while(row<=arr.length&&column>=0){
			if(arr[row][column] == target) return true;
			else if(arr[row][column] > target) column --;
			else row ++;
		}
		return false;
	}

}
