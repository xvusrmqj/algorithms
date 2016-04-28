import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

/**
 * ������ع�������
 * 
 * @author lv
 *
 */
public class Input {
	@Test
	/**
	 * next��nextLine scanner��next()��next()�������������nextLine()һ�ζ�ȡһ�У�
	 * ��next()һ�ζ�ȡһ���е�һ����Ĭ���Կո�Tab,�س��ָ�����
	 * hasNext()��hasNextLine()Ҳ����ˡ������ڵȴ�ɨ������ʱ���˷���������scanner��ִ���κ����롣
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
	 * scanner����nextInt,nextLong,nextByte()...�ȷ�������������nextLine��ȡ���Լ�����Ҳ���ԡ�
	 * �Լ���������ʹ��string.split()������ɡ�
	 */
	// note:there is no nextChar(), and there is no need.
	public void differentType() {
		Scanner scanner = new Scanner("true 0.1 0.2 1 2 3 4");
		System.out.println(scanner.nextBoolean());
		// ������float(32bit),double(64bit)
		System.out.println(scanner.nextFloat());
		System.out.println(scanner.nextDouble());
		// ���Ͱ���byte(8bit),short(16bit),int(32bit),long(64bit)
		System.out.println(scanner.nextByte());// -127~127
		System.out.println(scanner.nextShort());
		System.out.println(scanner.nextInt());
		System.out.println(scanner.nextLong());
		scanner.close();
	}

	@Test
	/**
	 * scanner�������ļ���InputStream��String��
	 * 
	 * @throws FileNotFoundException
	 */
	// the ".project" file is in the CommonTools directory.
	public void fromFile() throws FileNotFoundException {
		File file = new File(".project");
		// System.out.println(file.getAbsolutePath());
		Scanner scanner = new Scanner(new FileInputStream(file));
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}
}
