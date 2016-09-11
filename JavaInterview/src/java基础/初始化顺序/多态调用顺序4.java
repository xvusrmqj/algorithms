package java基础.初始化顺序;

//这个打印什么?
public class 多态调用顺序4 {

	static class Bowl {
		Bowl(int marker){
			System.out.println("bowl:"+marker);
		}
		void f1(int marker){
			System.out.println("f1:"+marker);
		}
	}

	static class Table {
		static Bowl bowl1 = new Bowl(1);
		static Bowl bowl2 = new Bowl(2);
		Table(){
			System.out.println("table");
			bowl2.f1(1);
		}
		void f2(int marker){
			System.out.println("f2:"+marker);
		}
	}
	static class Cupboard{
		Bowl bowl3 = new Bowl(3);
		static Bowl bowl4 = new Bowl(4);
		static Bowl bowl5 = new Bowl(5);
		public Cupboard() {
			System.out.println("Cupboard");
			bowl4.f1(2);
		}
		void f3(int marker){
			System.out.println("f3:"+marker);
		}
	}
	static class Test{
		public static void main(String[] args) {
			System.out.println("new cupboard-----");
			new Cupboard();
			System.out.println("new cupboard-----");
			new Cupboard();
			table.f2(1);
			cupboard.f3(1);
		}
		static Table table = new Table();
		static Cupboard cupboard = new Cupboard();
		
	}
}
