package application.model;

import java.io.Serializable;

public class Inspector implements Serializable{
	private String FirstName;
	private String LastName;
	private String ID;
	int numberOfReviews;
	private int inspector_number;
	
	public Inspector(String name, String last ,String iD)  {
		if(setID(iD) == false)
			System.out.println("Worng ID");
		this.FirstName = name;
		this.LastName = last;
		this.numberOfReviews = 0;
		this.inspector_number = RatingRestaurant.staticInspector_number;
	}

	public String getID() {
		return ID;
	}

	public boolean setID(String iD) {
		if(iD.length() != 9)
			return false;
		for (int i = 0; i < 9; i++ ) {
			if(iD.charAt(i) < 48 || iD.charAt(i) > 57)
				return false;
		}
		this.ID = iD;
		return true;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public int getInspector_number() {
		return inspector_number;
	}
	
	public void setReviewToRestaurant( Restaurant restaurant , float [] ratings , String opinion) {
		restaurant.setNewRating(ratings, opinion);
		numberOfReviews++;
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Inspector))
			return false;
		Inspector other = (Inspector) obj;
		if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append(inspector_number+") Inspector name : "+this.FirstName+"\nLast name : "+this.LastName
				+"\nID : "+this.ID+"\nnumber reviews : "+this.numberOfReviews);
		return toReturn.toString();
	}
	
	
	
	
	
	
	

	
}
