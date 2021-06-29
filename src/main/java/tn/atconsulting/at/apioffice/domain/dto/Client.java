package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
@Table(name="Client")
public class Client implements Serializable{
	
private static final long serialVersionUID = 1L;
	/*
	@ManyToOne
	Role role;
	
	*/
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long idClient;
	private long idRole ;
	private String name;
	private String email;
	private String adress;
	private String phone;	
	private String contact;
	private String type;	
	//=========================Getters and Setters =========================//

	
	public String getName() {
		return name;
	}
	

/*
	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}

*/

	public long getIdRole() {
		return idRole;
	}



	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}



	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", idRole=" + idRole + ", name=" + name + ", email=" + email
				+ ", adress=" + adress + ", phone=" + phone + ", contact=" + contact + ", type=" + type + "]";
	}



	



	


	
	
	
	
	

	
	
	

}
