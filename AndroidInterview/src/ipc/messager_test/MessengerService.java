package ipc.messager_test;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerService extends Service {
	private static class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			try {
				//接收到客户端发来的消息
				Log.i("Service", msg.getData().getString("key"));
				//向客户端发送消息
				Messenger client = msg.replyTo;
				Message message = new Message();
				Bundle data = new Bundle();
				data.putString("key", "come from service");
				message.setData(data);
				client.send(message);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			super.handleMessage(msg);
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return new Messenger(new MyHandler()).getBinder();
	}
}
