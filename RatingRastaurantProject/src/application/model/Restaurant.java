package application.model;

import java.io.Serializable;
import java.util.Arrays;

import application.model.enums.SanitationLevel;
import application.model.enums.resType;

public class Restaurant implements Serializable{
	private int Restaurant_number;
	private String RestaurantName;
	private Address RestaurantAddress;
	private int numberOfRating;
	private Rating ratings [];

	private resType resturantType;
	private SanitationLevel level;
	private final int sizeRatings = 5;
	private StringBuffer opinions;
	
	
	public Restaurant(String restaurantName, String area , String city , int num , resType type) {
		RestaurantName = restaurantName;
		RestaurantAddress = new Address(area, city, num);
		this.numberOfRating = 0;
		setRatings();
		this.resturantType = type;
		this.level = null;
		this.opinions =  new StringBuffer();
		this.Restaurant_number = RatingRestaurant.staticRestaurant_number;
	}
	
	private void setRatings() {
		this.ratings = new Rating[5];
		this.ratings[0] = new Rating("Total rating");
		this.ratings[1] = new Rating("Toilet cleaning");
		this.ratings[2] = new Rating("Eating and drinking utensils");
		this.ratings[3] = new Rating("Floor cleaning");
		this.ratings[4] = new Rating("Kitchen and bar cleaning");
	}

	public void setNewRating (float tempRatings [] , String opinion){
		float sum = 0;
		for (int i = 0 ; i < tempRatings.length ; i++) {
			this.ratings[i+1].addRate(tempRatings[i]);
			sum += tempRatings[i];
		}
		sum = sum /tempRatings.length;
		this.ratings[0].addRate(sum);
		setNewLevel();
		setNewOpinion(opinion);
		this.numberOfRating++;
	}

	private void setNewOpinion(String opinion) {
		this.opinions.append(opinion+"\n\n");
	}

	public String getAllOpinions() {
		return this.opinions.toString();
	}
	
	private void setNewLevel() {
		float ave = this.ratings[0].getAveRate();
		if(ave < 1.25)
			this.level = SanitationLevel.D;
		else if (ave < 2.5)
			this.level = SanitationLevel.C;
		else if (ave < 3.75)
			this.level = SanitationLevel.B;
		else
			this.level = SanitationLevel.A;
	}

	public int getRestaurant_number() {
		return Restaurant_number;
	}

	public String getRestaurantName() {
		return RestaurantName;
	}

	public Address getRestaurantAddress() {
		return RestaurantAddress;
	}

	public int getNumberOfRating() {
		return numberOfRating;
	}

	public Rating[] getRatings() {
		return ratings;
	}

	public resType getResturantType() {
		return resturantType;
	}

	public SanitationLevel getLevel() {
		return level;
	}

	public int getSizeRatings() {
		return sizeRatings;
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Restaurant))
			return false;
		Restaurant other = (Restaurant) obj;
		if (!RestaurantAddress.equals(other.RestaurantAddress))
			return false; 
		else if (!RestaurantName.equals(other.RestaurantName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append(Restaurant_number+") Restaurant name : "+this.RestaurantName);
		toReturn.append("\nRestaurant Address :\nArea : "+this.RestaurantAddress.getArea()
		+"\nCity : "+this.RestaurantAddress.getCity()+"\nhouse number : "+this.RestaurantAddress.getNumber());
		toReturn.append("\nNumber of raitings : "+this.numberOfRating);
		toReturn.append("\nRestaurant average rate: "+this.ratings[0].getAveRate());
		toReturn.append("\nRestaurant type :"+printType(this.resturantType));
		toReturn.append("\nRestaurant level :"+printLevel(this.level));
		
		if(!opinions.equals(null))
			toReturn.append("\nOpinions:\n\n"+opinions.toString());
		return toReturn.toString();
	}

	private String printLevel(SanitationLevel level2) {
		if(level2 == SanitationLevel.A)
			return "A";
		if(level2 == SanitationLevel.B)
			return "B";
		if(level2 == SanitationLevel.C)
			return "C";
		if(level2 == SanitationLevel.D)
			return "D";
		else
			return "null";
	}

	private String printType(resType resturantType2) {
		if(resturantType2 == resType.Bar)
			return "Bar";
		if(resturantType2 == resType.Barbecue)
			return "Barbecue";
		if(resturantType2 == resType.Cafe)
			return "Cafe";
		if(resturantType2 == resType.ChefRestaurant)
			return "Chef Restaurant";
		if(resturantType2 == resType.FastFood)
			return "Fast food";
		if(resturantType2 == resType.FishSeafood)
			return "Fish and sea food";
		if(resturantType2 == resType.RegularRestaurant)
			return "Regular restaurant";
		if(resturantType2 == resType.StreetFood)
			return "Street food";
		else
			return "null";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
