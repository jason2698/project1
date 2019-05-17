package Firstproject.eshop.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table
public class Customer {

@Id
@GeneratedValue

private int id;
private String firstname;
private String lastname;
private String phonenumber;

@OneToOne(cascade=CascadeType.ALL)

private UserDetail user;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="billing_id")

private BillingAddress billingaddress;

@OneToOne(cascade=CascadeType.ALL)

private ShippingAddress shippingaddress;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public UserDetail getUser() {
	return user;
}
public void setUser(UserDetail user) {
	this.user = user;
}
public BillingAddress getBillingaddress() {
	return billingaddress;
}
public void setBillingaddress(BillingAddress billingaddress) {
	this.billingaddress = billingaddress;
}
public ShippingAddress getShippingaddress() {
	return shippingaddress;
}
public void setShippingaddress(ShippingAddress shippingaddress) {
	this.shippingaddress = shippingaddress;
}

}
