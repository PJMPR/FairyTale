package domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries(
		{
			@NamedQuery(name= "lend.all", query=" SELECT l FROM Lend l")
		})
public class Lend implements IHaveId {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Book book;
	@OneToOne
	private Reader reader;
	
	private Date dateOfLend;
	private Date dateOfRegive;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
