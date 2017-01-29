package domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries(
		{
			@NamedQuery(name= "location.all", query=" SELECT l FROM Location l")
		})
public class Location implements IHaveId{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String street;
	
	private List<Reader> readers = new ArrayList<Reader>();
	
	@OneToMany(mappedBy="reader")
	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


}
