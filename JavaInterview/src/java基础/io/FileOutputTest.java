package java基础.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class FileOutputTest {
	@Test
	// no need file.createNewFile();
	public void writeTofile() throws IOException{
		File file = new File("src/resources/temp/write.txt");
		//1. FileOutputStream:字节流
		FileOutputStream fos = new FileOutputStream(file);
		byte[] b = new byte[4];
		b[0] = 0x61;//a
		b[1] = 0x62;//b
		b[2] = 0x63;//c
		b[3] = 0x64;//d
		fos.write(b);
		fos.close();
		//2. FileWriter：字符流
		FileWriter fw = new FileWriter(file);
		fw.write("hello");
		fw.close();
		//3. PrintWriter：字符流
		PrintWriter pw = new PrintWriter(file);
		pw.write("how are you?\n");
		pw.write("fine,thank you!");
		pw.close();
	}
}
