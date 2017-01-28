package rest.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BookDto {
	
	private int id;
	private String name;
	private String author;
	private Date dateOfReleased;
	private String publisher;
	private int pageCount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDateOfReleased() {
		return dateOfReleased;
	}
	public void setDateOfReleased(Date dateOfReleased) {
		this.dateOfReleased = dateOfReleased;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}
