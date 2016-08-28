package ipc.aidl_test.client;

import java.util.List;

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
import ipc.aidl_test.Book;
import ipc.aidl_test.IbookManager;
import ipc.aidl_test.service.BookManagerService;

public class BookManagerClient extends Activity {
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
		}

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder ibinder) {
			try {
				//从服务端取东西
				IbookManager bookManager = IbookManager.Stub.asInterface(ibinder);
				//这里可能很耗时， 应该放在一个线程里执行
				List<Book> bookList = bookManager.getBookList();
				Log.e("client", bookList.get(0).toString());
				//rpc
				bookManager.addBook(new Book(3, "python"));
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
		Intent intent = new Intent(this, BookManagerService.class);
		bindService(intent, conn, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onDestroy() {
		unbindService(conn);
		super.onDestroy();
	}
}
