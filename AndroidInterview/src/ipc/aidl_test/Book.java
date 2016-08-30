package ipc.aidl_test;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
	private int bookId;
	private String bookname;

	@Override
	public String toString() {
		return "bookid=" + bookId + ",bookname = " + bookname;
	}

	public Book(int bookId, String bookname) {
		this.bookId = bookId;
		this.bookname = bookname;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(bookId);
		dest.writeString(bookname);
	}

	public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {

		@Override
		public Book[] newArray(int size) {
			return new Book[size];
		}

		@Override
		public Book createFromParcel(Parcel source) {
			int bookId = source.readInt();
			String bookname = source.readString();
			return new Book(bookId,bookname);
		}
	};
}
