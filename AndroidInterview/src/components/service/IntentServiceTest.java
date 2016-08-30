package components.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
/**
 * IntentService示例
 * @author lv
 *
 */
public class IntentServiceTest extends IntentService {
	//这里的写法是固定的，1. 要求有一个无参的构造函数    2.父类要求调用有参的构造函数。
	public IntentServiceTest() {
		super("Server");
	}
	//实现在这个方法里就可以，它自己会加上线程
	@Override
	protected void onHandleIntent(Intent intent) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.e("IntentServiceTest", "耗时任务,如果要交互的话，用广播或者是传来个handler?");
		
	}

}
