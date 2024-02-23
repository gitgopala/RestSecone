package com.slokam.oauth.RestSec;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class AppUser {

	@Id
	@GeneratedValue
	private Integer id;
	private String userName;
	private String password;
	
	@ManyToMany
	@JoinTable(
			name= "userrole",
			joinColumns = {@JoinColumn(name="userid")},
			inverseJoinColumns = {@JoinColumn(name="roleid")}
			)
	private List<AppRole> approle;
	
	
	
	public List<AppRole> getApprole() {
		return approle;
	}
	public void setApprole(List<AppRole> approle) {
		this.approle = approle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
