package java基础.集合;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  字节流--->字符流 ：
 *  	1. InputStreamReader.
 *  	2. OutputStreamWriter.
 *  字符流--->字节流
 *  	没有必要提供.
 * @author lv
 *
 */
public class 转换流 {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in); //就这一句就将字节流--->字符流了
		BufferedReader br = new BufferedReader(ir);
		String s = null;
		while((s = br.readLine())!=null){
			System.out.println(s);
		}
	}
}
