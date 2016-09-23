package optimize;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class GetInfoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//查询当前应用的Heap Size阈值，getMemoryClass会返回一个整数，表明应用的Heap Size阈值是多少MB
		ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		int heapSize = am.getMemoryClass();
		Log.e("GetInfoActivity", "heapSize:"+heapSize);
	}
}
