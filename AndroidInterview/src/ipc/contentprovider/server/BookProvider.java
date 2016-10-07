package ipc.contentprovider.server;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * *************************
 * 自己写的ContentProvider,在执行完insert、delete和update后，
 * 要手动地调用getContentResolver().notifyChange()这个方法来通知改动的产生。
 * http://blog.csdn.net/shineflowers/article/details/44461333
 * @author lv
 *
 */
public class BookProvider extends ContentProvider {
	// 这里暂时没有用到UriMatcher， 因为就一个表也没啥要匹配的。
	//	public static final String AUTHORITY = "ipc.contentprovider.BookProvider";
	//	public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
	//	public static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	//	static {
	//		uriMatcher.addURI(AUTHORITY, "book", 0);
	//	}
	private SQLiteDatabase db;

	@Override
	public boolean onCreate() {
		db = new DbOpenHelper(getContext()).getWritableDatabase();
		db.execSQL("delete from book");
		db.execSQL("insert into book values(10,'hello10')");
		db.execSQL("insert into book values(9,'hello9')");
		db.execSQL("insert into book values(8,'hello8')");
		db.execSQL("insert into book values(7,'hello7')");
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		Cursor query = db.query("book", projection, selection, selectionArgs, null, sortOrder, null, null);
		return query;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long id = db.insert("book", null, values);
		getContext().getContentResolver().notifyChange(uri, null);
		return ContentUris.withAppendedId(uri, id);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}

}
