import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class StoreCredit {
	@Test
	public void test() throws IOException{
//		Scanner sc = new Scanner("how are you \n fine");
		Scanner sc = new Scanner("how are you"+System.getProperty("line.separator")+"fine");
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.nextLine());//can not get the word "fine".
		sc.close();
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("resources/StoreCredit/A-large-practice.in"));
		PrintWriter pw  = new PrintWriter(new File("resources/StoreCredit/result.txt"));
		int total = sc.nextInt();
		for (int i = 0,caseCount = 1; i < total * 3; i += 3,caseCount++) {
			int sum = sc.nextInt();
			int count = sc.nextInt();
			sc.nextLine();
			String[] items_String = sc.nextLine().split(" ");
			int[] items = new int[items_String.length];
			for (int j = 0; j < items.length; j++) {
				items[j] = Integer.parseInt(items_String[j]);
			}
			
			String msg = printResult(caseCount,sum, items);
			pw.println(msg);
		}
		sc.close();
		pw.close();
	}

	private static String printResult(int caseCount,int sum, int[] items) throws IOException {
		for (int i = 0; i < items.length; i++) {
			for (int j = i+1; j < items.length; j++) {
				if(items[i]+items[j]==sum){
					String message = "Case #"+caseCount+": "+(++i)+" "+(++j);
					return message;
				}
			}
		}
		return null;
	}

}
