package tma.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "user_pkey", columnNames = {"username"})})
public class User implements Serializable{

	private static final long serialVersionUID = -793141959445501782L;
	
	@Id
	@Column(name = "username")
	private String username;
	
	public User() {}
	
	public User(String username) {
		super();
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
}
