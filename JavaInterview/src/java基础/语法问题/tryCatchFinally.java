package java基础.语法问题;

public class tryCatchFinally {
	public static void main(String[] args) {
		String fun = new tryCatchFinally().fun();
		System.out.println("+++fun:"+fun);
	}
public String fun(){
	try {
		System.out.println("try-------");
		return "TRY";
	} catch (Exception e) {
		System.out.println("catch-----");
//		return "TRY";
	}finally{
		System.out.println("finally-----");
		return "finally";
	}
}
}
