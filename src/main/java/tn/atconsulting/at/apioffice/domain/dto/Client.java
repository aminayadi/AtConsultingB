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
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String type;
	private String address;
	private String secrétaire_général;
	private String email;
	private String num_telefone;
	
	//=========================Getters and Setters =========================//
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSecrétaire_général() {
		return secrétaire_général;
	}
	public void setSecrétaire_général(String secrétaire_général) {
		this.secrétaire_général = secrétaire_général;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum_telefone() {
		return num_telefone;
	}
	public void setNum_telefone(String num_telefone) {
		this.num_telefone = num_telefone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "client [id=" + id + ", name=" + name + ", type=" + type + ", address=" + address
				+ ", secrétaire_général=" + secrétaire_général + ", email=" + email + ", num_telefone=" + num_telefone
				+ "]";
	}
	
	
	

	
	
	

}
