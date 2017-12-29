package com.otostore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "vendor")
@NamedQueries({
		@NamedQuery(name = "Vendor.findAll" , query="SELECT o FROM Vendor o"),
		@NamedQuery(name = "Vendor.vendorName" , query="SELECT o FROM Vendor As o WHERE o.vendorName = :vendorName"),
		@NamedQuery(name = "Vendor.vendorCount", query="SELECT COUNT(o) FROM Vendor o"),
		@NamedQuery(name = "Vendor.vendorVehicles", query="SELECT o FROM Vendor o LEFT OUTER JOIN FETCH o.vehicles WHERE o.id = (:id)")
	
})
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(max = 50,min = 3)
	private String firstName;
	
	@NotNull
	@Size(max = 50,min = 3)
	private String lastName;
	
	@Column(unique=true)
	@NotNull
	@Size(max = 20,min = 10)
	private String vendorName;
	
	@NotNull
	@Size(max = 20,min = 10)
	private String phone;
	
	@NotNull
	@Size(max = 50,min = 6)
	private String email;
	
	@NotNull
	@Size(max = 12,min = 8)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "vendor")/*OnetoMany:bir tablonun diğer bir tablo içerisinde birden çok alanla eşleştirildiğ ilişkilerdir.
	cascadeType.ALL olarak tanımlandığı için tüm cascade tipler birlikte yapılacaktır.*/
	private List<Vehicle> vehicles;
	
	public Vendor() {
		
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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return new StringBuilder("Vendor [")
				.append("id=").append(id)
				.append(",firsName=").append(firstName)
				.append(",lastName=").append(lastName)
				.append(",vendorName=").append(vendorName)
				.append(",phone=").append(phone)
				.append(",email=").append(email)
				.append(",password=").append(password)
				.append("]").toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vendorName == null) ? 0 : vendorName.hashCode());
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
		Vendor other = (Vendor) obj;
		if (vendorName == null) {
			if (other.vendorName != null)
				return false;
		} else if (!vendorName.equals(other.vendorName))
			return false;
		return true;
	}
	
	
}
