package 数据结构.队列;

public class 循环队列 {
	int[] arr = null;

	public 循环队列(int[] arr) {
		this.arr = arr;
	}

	public void 遍历(int start) throws InterruptedException {
		int i = start;
		System.out.print(arr[i]);
		while (true) {
			
			int next = ++i % arr.length;
			if (next == start)
				break;
			System.out.print(arr[next]);
		}
	}

	public static void main(String[] args) {
		try {
			new 循环队列(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }).遍历(5);
		} catch (Exception e) {
			System.out.println("22===");
		}
	}

}
