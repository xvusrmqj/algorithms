package ipc.aidl_test.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import ipc.aidl_test.Book;
import ipc.aidl_test.IbookManager;

public class BookManagerService extends Service {
	private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<Book>();
	private Binder mBinder = new IbookManager.Stub() {

		@Override
		public List<Book> getBookList() throws RemoteException {
			return mBookList;
		}

		@Override
		public void addBook(Book book) throws RemoteException {
			Log.e("service", book.toString());
			mBookList.add(book);
		}
	};

	@Override
	public void onCreate() {
		super.onCreate();
		mBookList.add(new Book(1, "android"));
		mBookList.add(new Book(2, "JAVA"));
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

}
