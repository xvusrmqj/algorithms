package ipc.contentprovider.client;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ProviderActivity extends Activity {

	Uri uri = Uri.parse("content://ipc.contentprovider.BookProvider/book");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		ContentValues values = new ContentValues();
		values.put("id", 2);
		values.put("name", "程序员面试金典2");
		getContentResolver().insert(uri, values);
		setContentView(tv);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Cursor cursor = getContentResolver().query(uri, new String[] { "id", "name" }, null, null, null);
		Toast.makeText(this, "cursor:"+cursor, 1).show();
		System.err.println("11111111111111"+cursor);
		while(cursor.moveToNext()){
			Log.e("client", cursor.getInt(0)+","+cursor.getString(1));
		}
		cursor.close();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
