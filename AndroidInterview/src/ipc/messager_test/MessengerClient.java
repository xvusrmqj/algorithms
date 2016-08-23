package ipc.messager_test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;

public class MessengerClient extends Activity {
	private Handler clientHandler = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("client", msg.getData().getString("key"));
		};
	};
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
		}

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder ibinder) {
			try {
				//向服务端发送消息
				Message msg = Message.obtain();
				Bundle bundle = new Bundle();
				bundle.putString("key", "client--come from client");
				msg.setData(bundle);
				//将这个传过去，服务端就能给客户端发东西了。
				msg.replyTo = new Messenger(clientHandler);
				new Messenger(ibinder).send(msg);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("hello, i am client");
		setContentView(tv);
		Intent intent = new Intent(this, MessengerService.class);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onDestroy() {
		unbindService(conn);
		super.onDestroy();
	}
}
