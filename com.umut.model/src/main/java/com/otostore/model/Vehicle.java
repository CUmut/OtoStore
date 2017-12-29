package com.otostore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="vehicle")
@NamedQueries({
		@NamedQuery(name ="Vehicle.findAll", query = "SELECT o FROM Vehicle o"),
		@NamedQuery(name="Vehicle.findByVendorName", query="SELECT o FROM Vehicle As o WHERE o.vendorName = :vendorName"),
		@NamedQuery(name="Vehicle.vehicleCount",query="SELECT COUNT(o) FROM Vehicle o")
})
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 30)
	private String make;
	
	@NotNull
	@Size(max = 30)
	private String model;
	
	@NotNull
	private int year;
	private double price;
	
	@Size(max =500)
	private String description;
	
	@Size(max = 500)
	private String imagePath;
	
	@Column(name = "addDate" , updatable = false)
	private Date addDate;
	private Date updateDate;
	
	private String isNew;
	
	private String fuel;
	private String vendorName;
	
	@ManyToOne(fetch = FetchType.EAGER)/*Bu komut ile veriye doğrudan ve hemen erişim isteğinin iletildiği yöntemdir.İşaratlenen alan yada collection first level nesne muamelesi görür.*/
	private Vendor vendor;
	
	
	public Vehicle() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public String getIsNew() {
		return isNew;
	}


	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}


	public String getFuel() {
		return fuel;
	}


	public void setFuel(String fuel) {
		this.fuel = fuel;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public Vendor getVendor() {
		return vendor;
	}


	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}


	@Override
	public String toString() {
		return new StringBuilder("Vehicle [")
				.append("id=").append(id)
				.append(",make=").append(make)
				.append(",model=").append(model)
				.append(",year=").append(year)
				.append(",price=").append(price)
				.append(",description=").append(description)
				.append(",imagePath=").append(imagePath)
				.append(",addDate=").append(addDate)
				.append(",updateDate=").append(updateDate)
				.append(",isNew=").append(isNew)
				.append(",fuel=").append(fuel)
				.append(",vendorName").append(vendorName)
				.append("]").toString();
				
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
