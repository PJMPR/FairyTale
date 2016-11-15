package domain.model;

import java.util.ArrayList;
public class Reader extends Person {

	private ArrayList<Book> listOfBooks = new ArrayList<Book>();
	private String phoneNumber;
	private String email;
	private String location;
	private String street;
	private String address;
	
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	
	
}
