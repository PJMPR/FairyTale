package rest.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LendDto {

	private Date dateOfLend;
	private Date dateOfRegive;
	
	
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
