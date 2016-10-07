package ipc.contentprovider.client;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class MyContentObserver extends android.database.ContentObserver {
	private Context mContext;
	Handler handler;

	public MyContentObserver(Context context, Handler handler) {
		super(handler);
		mContext = context;
		this.handler = handler;
	}

	/** 
	 * 当所监听的Uri发生改变时，就会回调此方法 
	 *  
	 * @param selfChange 此值意义不大 一般情况下该回调值false 
	 */
	@Override
	public void onChange(boolean selfChange) {
		Log.e("ContentObserver", "------------onChange-----------");
		Message msg = Message.obtain();
		msg.what = 1;
		msg.obj = "hello";
		handler.handleMessage(msg);
	}
}
