package JavaSE.常用工具类;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class 序列化 {
	/**
	 * 
	 */
	public static void main(String[] args) throws Exception {
//		序列化方法();
//		反序列化方法();
	}

	private static void 反序列化方法() throws IOException, FileNotFoundException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.txt"));
		Person readObject = (Person) ois.readObject();
		String name = readObject.name;
		int age = readObject.age;
		System.out.println("name = "+name+": age = "+age);
	}

	private static void 序列化方法() throws IOException, FileNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
		oos.writeObject(new Person("xiaoming", 15));
		oos.close();
	}

	static class Person implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name;
		private int age;

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

	}

}
