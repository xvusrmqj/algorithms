package components.service.intentService;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Server extends IntentService {

	public Server() {
		super("Server");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.e("server", "耗时任务,如果要交互的话，用广播或者是传来个handler?");
		
	}

}
