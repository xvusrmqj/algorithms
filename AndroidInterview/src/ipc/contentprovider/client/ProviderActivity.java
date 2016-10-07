package ipc.contentprovider.client;

import android.app.Activity;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProviderActivity extends Activity implements OnClickListener {
	int id = 0;
	Uri uri = Uri.parse("content://ipc.contentprovider.BookProvider/book");
	ContentObserver observer;
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			System.out.println(msg.obj);
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button button = new Button(this);
		button.setText("chang the data");
		button.setOnClickListener(this);
		observer = new MyContentObserver(this, handler);
		getContentResolver().registerContentObserver(uri, true, observer);
		setContentView(button);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Cursor cursor = getContentResolver().query(uri, new String[] { "id", "name" }, null, null, null);
		while (cursor.moveToNext()) {
			Log.e("client", cursor.getInt(0) + "," + cursor.getString(1));
		}
		cursor.close();
	}

	@Override
	protected void onDestroy() {
		getContentResolver().unregisterContentObserver(observer);
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		ContentValues values = new ContentValues();
		values.put("id", id++);
		values.put("name", "程序员面试金典1112");
		getContentResolver().insert(uri, values);

	}
}
