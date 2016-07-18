package io;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

//TODO 未做
/*
 *  1、File类的createNewFile根据抽象路径创建一个新的空文件，当抽象路径制定的文件存在时，创建失败  
 *  2、File类的mkdir方法根据抽象路径创建目录  
 *  3、File类的mkdirs方法根据抽象路径创建目录，包括创建必需但不存在的父目录  
 *  4、File类的createTempFile方法创建临时文件，可以制定临时文件的文件名前缀、后缀及文件所在的目录，如果不指定目录，则存放在系统的临时文件夹下。  
 *  5、除mkdirs方法外，以上方法在创建文件和目录时，必须保证目标文件不存在，而且父目录存在，否则会创建失败  
 */
public class FileTest {
	@Test
	// path is ../resources/createFile.txt
	public void createFile() throws IOException {
		// path1  will get wrong log ：java.io.IOException: 系统找不到指定的路径。
		// 因为相对路径是从项目文件夹下开始找的，所以没有resources文件夹，resources文件夹在src下。
		String path1 = ".." + File.separator + "resources" + File.separator + "createFile.txt";
		// path2 will create success.
		String path2 = "src" + File.separator + "resources" + File.separator + "createFile.txt";
		// 通常都是创建到class路径下，而不是src下,虽然src下也能拷备到class下
		String path3 = getClass().getResource("/").getPath();
		path3 += "resources/temp/test.txt";
		File f = new File(path3);
		createFile(f);
	}

	@Test
	public void fileInfo() {
		// java中将相对路径解释为用户工作目录开始。
		// 1. 打印工作目录。
		String property = System.getProperty("user.dir");
		System.out.println(property);
		// 2. 打印分隔符
		String separator = File.separator;
		System.out.println(separator);
		// 3. 打印URL信息，通过URL可以方便的得到path等。
		URL resource1 = getClass().getResource("");//file:/C:/xxx/CommonTools/bin/io/
		URL resource2 = getClass().getResource(".");//file:/C:/xxx/CommonTools/bin/io/
		URL resource3 = getClass().getResource("..");//file:/C:/xxx/CommonTools/bin/

		URL resource4 = getClass().getResource("/");//file:/C:/xxx/CommonTools/bin/
		URL resource5 = getClass().getResource("/io/FileTest.class");//file:/C:/xxx/CommonTools/bin/io/FileTest.class
		System.out.println(resource1);
		System.out.println(resource2);
		System.out.println(resource3);
		System.out.println(resource4);
		System.out.println(resource5);

	}

	@Test
	public void getFile() {
		File f = new File("src/io/FileTest.java");
		System.out.println(f.exists());
	}

	@Test
	public void deleteFile() {
		String path = getClass().getResource("/").getPath();
		path += "resources/temp/test.txt";
		File f = new File(path);
		if (f.exists()) {
			boolean delete = f.delete();
			System.out.println("delete success:" + delete);
		} else {
			System.out.println("not exist!");
		}
	}

	private static void createFile(File f) throws IOException {
		if (f.exists()) {
			System.out.println("exist");
		} else {
			boolean b = f.createNewFile();
			System.out.println("create file:" + b);
		}
	}

}
