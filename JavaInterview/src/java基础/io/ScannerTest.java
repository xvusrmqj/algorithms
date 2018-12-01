package java基础.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

/**
 * 输入相关功能用例
 * 
 * @author lv
 *
 */
public class ScannerTest {
	@Test
	/**
	 * next与nextLine scanner的next()和next()方法的区别就是nextLine()一次读取一行，
	 * 而next()一次读取一行中的一个（默认以空格，Tab,回车分隔）。
	 * hasNext()和hasNextLine()也是如此。不过在等待扫描输入时，此方法阻塞，scanner不执行任何输入。
	 */
	// if the input is "a b"
	public void nextAndNextLine() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());// print a b
		System.out.println(scanner.next());// print a
		System.out.println(scanner.next());// print b
		scanner.close();
	}

	@Test
	/**
	 * scanner还有nextInt,nextLong,nextByte()...等方法，不过都用nextLine读取再自己解析也可以。
	 * 自己解析可以使用string.split()方法完成。
	 */
	// note:there is no nextChar(), and there is no need.
	public void differentType() {
		Scanner scanner = new Scanner("true 0.1 0.2 1 2 3 4");
		// boolean (not 2bit it's virtual machine dependent.)
		System.out.println(scanner.nextBoolean());
		// 浮点型float(32bit),double(64bit)
		System.out.println(scanner.nextFloat());
		System.out.println(scanner.nextDouble());
		// 整型包括byte(8bit),short(16bit),int(32bit),long(64bit)
		System.out.println(scanner.nextByte());// -127~127
		System.out.println(scanner.nextShort());
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextLong());
		scanner.close();
	}

	@Test
	/**
	 * scanner可以是文件，InputStream，String等
	 * 
	 * @throws FileNotFoundException
	 */
	public void fromFile() throws FileNotFoundException {
		File file = new File("index.md");
		// System.out.println(file.getAbsolutePath());
		Scanner scanner = new Scanner(new FileInputStream(file));
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}
}
