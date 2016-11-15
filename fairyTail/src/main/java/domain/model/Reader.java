package domain.model;

import java.util.ArrayList;
public class Reader extends Person {

	private int id;
	private ArrayList<Book> listOfBooks = new ArrayList<Book>();
	private String phoneNumber;
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Book> getListOfBooks() {
		return listOfBooks;
	}

	public  void addBook(Book book)
	{
		listOfBooks.add(book);
	}
	
	public void returnBook(Book book)
	{
		listOfBooks.remove(book);
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
}
