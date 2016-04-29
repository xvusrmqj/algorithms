package toolsOperations;
import commonOperations.InputTest;

/**
 * 对于注释的说明
 * @author lv
 * 
 */
public class AnnotationExplainations {
	//html
	/**
	 * javadoc can use html lable.
	 * <em>hello</em>
	 */
	public void test1(){
		
	}
	//@see
	//@author can have many authors
	/**
	 * @see InputTest 
	 * @see java.lang.String
	 * look!  the classes after see can be click in eclipse. 
	 * @author lv1
	 * @author lv2
	 * @author lv3
	 */
	public void test2(){
		System.out.println();
	}
	
	//@param
	//@return
	//@throws
	//@deprecated
	/**
	 * @return 0
	 * @param s
	 * @deprecated
	 * @throws NullPointerException
	 */
	public int test3(String s) throws NullPointerException{
		return 0;
	}
}
