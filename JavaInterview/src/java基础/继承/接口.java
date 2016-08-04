package java基础.继承;

public class 接口 {
	public static interface MyFace{
		void fun();
	}
	public static void main(String[] args) {
		MyFace i = new MyFace(){
			@Override
			public void fun() {
				
			}
		};
	}
}
