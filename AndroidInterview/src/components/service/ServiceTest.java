package components.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
/**
 * 常规Service
 * @author lv
 *
 */
public class ServiceTest extends Service{
	@Override
	public void onCreate() {
		super.onCreate();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.e("ServiceTest", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public IBinder onBind(Intent arg0) {
		Log.e("ServiceTest", "onBind");
		return null;
	}

}
