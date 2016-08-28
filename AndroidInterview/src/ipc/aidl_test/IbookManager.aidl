package ipc.aidl_test;
import ipc.aidl_test.Book;
interface IbookManager{
	List<Book> getBookList();
	void addBook(in Book book);
}