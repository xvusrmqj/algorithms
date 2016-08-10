package java基础.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 通过读10行100行100000行,发现BufferedReader比Scanner快.
 * @author lv
 *
 */
public class Scanner与BufferedReader谁快 {
	public static void main(String[] args) throws IOException {
		//		genText(10);
		//		genText(100);
//				genText(1000000);
				
		File file = new File("./hello.txt");
		long begin = System.nanoTime();
		useBufferedReader(file);
		long end = System.nanoTime();

		long begin2 = System.nanoTime();
		useScanner(file);
		long end2 = System.nanoTime();
		
		long begin3 = System.nanoTime();
		useScannerWithBufferedInputStream(file);
		long end3 = System.nanoTime();

		long s1 = end - begin;
		long s2 = end2 - begin2;
		long s3 = end3 - begin3;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
//		System.out.println(Math.max(s1, s2));
//		System.out.println(Math.max(s1, s2));

	}

	private static void genText(int n) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("./hello.txt"));
		for (int i = 0; i < n; i++) {
			pw.println("Line:" + i);
		}
		pw.close();
	}

	/**
	 * 使用BufferedReader
	 * @param file
	 * @throws IOException
	 */
	private static void useBufferedReader(File file) throws IOException {
		FileInputStream fs = new FileInputStream(file);
		InputStreamReader ir = new InputStreamReader(fs); //就这一句就将字节流--->字符流了
		BufferedReader br = new BufferedReader(ir);
		List<String> list = new LinkedList<>();
		String s = null;
		while ((s = br.readLine()) != null) {
			list.add(s);
		}
		ir.close();
		br.close();
	}

	/**
	 * 
	 * 使用Scanner
	 * @param file
	 * @throws IOException
	 */
	private static void useScanner(File file) throws IOException {
		Scanner sc = new Scanner(file);
		List<String> list = new LinkedList<>();
		while (sc.hasNext()) {
			list.add(sc.nextLine());
		}
		sc.close();
	}

	/**
	 * 
	 * 使用Scanner包上BufferedInputStream, 当然也能包上BufferedReader
	 * @param file
	 * @throws IOException
	 */
	private static void useScannerWithBufferedInputStream(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		Scanner sc = new Scanner(bis);
		List<String> list = new LinkedList<>();
		while (sc.hasNext()) {
			list.add(sc.nextLine());
		}
		sc.close();
	}
}
