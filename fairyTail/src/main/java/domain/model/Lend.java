package domain.model;

import java.util.Date;

public class Lend {

	private int id;
	private Librarian librarian;
	private Book book;
	private Reader reader;
	private Date dateOfLend;
	private Date dateOfRegive;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Librarian getLibrarian() {
		return librarian;
	}
	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public Date getDateOfLend() {
		return dateOfLend;
	}
	public void setDateOfLend(Date dateOfLend) {
		this.dateOfLend = dateOfLend;
	}
	public Date getDateOfRegive() {
		return dateOfRegive;
	}
	public void setDateOfRegive(Date dateOfRegive) {
		this.dateOfRegive = dateOfRegive;
	}
}
