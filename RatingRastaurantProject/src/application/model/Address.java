package application.model;

import java.io.Serializable;

public class Address implements Serializable{
	
	private String Area;
	private String city;
	private int number;
	
	public Address (String area , String city , int num) {
		this.Area = area;
		this.city = city;
		this.number = num;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (Area == null) {
			if (other.Area != null)
				return false;
		} else if (!Area.equals(other.Area))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}
}
	
	
