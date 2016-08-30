package ipc.contentprovider.server;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * SQLiteOpenHelper: A helper class to manage database creation and version management. 
 * @author lv
 *
 */
public class DbOpenHelper extends SQLiteOpenHelper {

	public DbOpenHelper(Context context) {
		super(context, "book_provider.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS book (id INTEGER PRIMARY KEY, name TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}
