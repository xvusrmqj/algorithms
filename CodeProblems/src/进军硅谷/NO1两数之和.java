package 进军硅谷;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author lv
 *
 */
public class NO1两数之和 {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(fun(arr,18));
	}

	public static boolean fun(int[] arr,int target) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int find = target-arr[i];
			if(set.contains(find)) return true;
			else set.add(arr[i]);
		}
		return false;
		
	}

}
