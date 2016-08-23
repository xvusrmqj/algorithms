package java高级.多线程;

/**
 * 

                         +---------+ 阻 塞  <------------+
                         |                             |
                         | sleep时 间 到           	   sleep() |
                         | IO返 回           		    io     |
                         | 获 得 锁               		         等 待 锁   |
                         | 收 到 通 知             	     等 待 通 知 |
                         | resume              suspend |
                         |                             |
                         |                             |
                         |                             |
                         |                             +
           start()       v       获 得 CPU                     run() 完 成
    新 建 +-------------->就 绪 +----------------------> 运 行 +----------------------> 死 亡
                           <-----------------------+         error or exception
                                                                                 失 去 CPU or yeild()


                                +----------------+
                                |线 程 状 态 转 换 图 |
                                +----------------+
 * @author lv
 *
 */
public class 线程状态转换 {
	
	public static void main(String[] args) throws InterruptedException {
		//1. 创建--->就绪
		Thread thread = new Thread(){
			public void run() {
				for(int i = 0;i<20;i++){
					if(i==10)
						try {
							Thread.sleep(1234);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					System.out.println(System.currentTimeMillis()+":"+i);
				}
			};
		};
		thread.start();
		//2. 就绪--->运行
		//3. 运行到--->就绪
		Thread.yield();
		
	}
	//when new Thread()，the thread 创建.
	//when start(),the thread 就绪
	public static void createThread(){
		//1. 
		new MyThread().start();
		//2. 推荐
		new Thread(new MyRunnable()).start();
	}
}
class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("MyThread");
	}
}
class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("MyRunnable");
	}
}

