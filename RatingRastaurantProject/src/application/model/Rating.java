package application.model;

import java.io.Serializable;

public class Rating implements Serializable{
	
	private String ratingType;
	private int numberOfRate;
	private float allRates;
	private float aveRate;
	
	
	public Rating(String ratingType) {
		this.ratingType = ratingType;
		this.numberOfRate = 0;
		this.allRates = 0;
		this.aveRate = 0;
	}
	
	public void addRate (float newRate) {
		this.numberOfRate++;
		this.allRates += newRate;
		this.aveRate = allRates / numberOfRate;
	}

	public String getRatingType() {
		return ratingType;
	}

	public int getNumberOfRate() {
		return numberOfRate;
	}

	public float getAllRates() {
		return allRates;
	}

	public float getAveRate() {
		return aveRate;
	}
	
	
	
	
	
	

}

