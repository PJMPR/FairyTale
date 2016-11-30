package domain.model;


public class Reader implements IHaveId {

	private int id;
	private String phoneNumber;
	private String email;
	private String firstName;
	private String lastName;
	private Location address;
	
	
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

	public Location getAddress() {
		return address;
	}

	public void setAddress(Location address) {
		this.address = address;
	}
	
	
	

	

	
	
}
