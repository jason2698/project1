package Firstproject.eshop.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDetail 
{
@Id
//@GeneratedValue
//int userId;
//public int getUserId() {
//	return userId;
//}
//public void setUserId(int userId) {
//	this.userId = userId;
//}
String username;
String password;
String customername;
String address;
boolean enabled;
String emailId;
String role;
String mobilenumber;

public String getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}
//Authorities authorities;
//public Authorities getAuthorities() {
	//return authorities;
//}
//public void setAuthorities(Authorities authorities) {
	//this.authorities = authorities;
//}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
