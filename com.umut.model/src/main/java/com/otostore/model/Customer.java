package com.otostore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity /*Entity Object denir.Bir sınıf bu anotasyon ile işaretlendiğinde  o sınıf için tablo oluşturalacak  demektir.*/
@Table(name="customer")
@NamedQueries({
	@NamedQuery(name ="Customer.findAll",query="SELECT o FROM Customer o"),
	@NamedQuery(name="Customer.findByProfileName", query="SELECT o FROM Customer As o WHERE o.profileName = :profileName"),
	@NamedQuery(name="Customer.customerCount", query="SELECT COUNT(o) FROM Customer o")
})
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) /*GeneratedValue ile ıd değerinin nasıl üretileceği belirlenir*/
	private Long id;
	
	@NotNull
	@Size(max = 50,min = 3)
	private String firstName;
	
	@NotNull
	@Size(max = 50,min = 3)
	private String lastName;
	
	@Column(unique = true)
	@NotNull
	@Size(max = 50, min = 6)
	private String profileName;
	
	
	@NotNull
	@Size(max = 20,min = 10)
	private String  phone;
	
	@NotNull
	@Size(max = 50,min = 6)
	private String email;
	
	@NotNull
	@Size(max = 12,min=8)
	private String password;
	
	public Customer() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return new StringBuilder("Customer[").append("id").append(id)
				.append(",firstName=").append(firstName)
				.append(",lastName=").append(profileName)
				.append(",profileName=").append(profileName)
				.append(",phone=").append(phone)
				.append(",email=").append(email)
				.append(",password=").append(password)
				.append("]").toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profileName == null) ? 0 : profileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (profileName == null) {
			if (other.profileName != null)
				return false;
		} else if (!profileName.equals(other.profileName))
			return false;
		return true;
	}
	
	
	
	
}
