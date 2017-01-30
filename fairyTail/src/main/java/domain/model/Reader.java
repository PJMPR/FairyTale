package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="reader")
@NamedQueries(
		{
			@NamedQuery(name= "reader.all", query=" SELECT r FROM Reader r"),
			@NamedQuery(name= "reader.id", query=" SELECT r FROM Reader r WHERE r.id=:id")
		})
public class Reader implements IHaveId {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String phoneNumber;
	private String email;
	private String firstName;
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name="ADDRESS_ID")
	private Location location;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	

	

	
	
}
