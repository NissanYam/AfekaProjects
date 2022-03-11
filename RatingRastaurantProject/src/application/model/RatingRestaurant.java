package application.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class RatingRestaurant implements Serializable{
	public static int staticInspector_number = 1;
	public static int staticRestaurant_number = 1;
	public Vector<String> Areas  ;
	public Map<String,Vector<String>> Cities;
	private Vector<Restaurant> restaurants;
	private Vector<Inspector> inspectors;
	private static RatingRestaurant Rating_Restaurant = null;
	private FactoryObjects factory;
	
	private RatingRestaurant (){
		this.restaurants = new Vector<Restaurant>();
		this.inspectors = new Vector<Inspector>();
		this.factory = FactoryObjects.getFactory_Objects();
		this.Areas = new Vector<String>();
		this.Cities = new LinkedHashMap<String, Vector<String>>();
	}
	
	/// Design pattern singleton /*only one application
	public static RatingRestaurant getRating_Restaurant() {
		if(Rating_Restaurant == null)
			Rating_Restaurant = new RatingRestaurant();
			
		return Rating_Restaurant;
	}
	
	public Vector<Restaurant> getRestaurants() {
		return restaurants;
	}
	
	public Vector<Inspector> getInspectors() {
		return inspectors;
	}
	
	public Vector <String> getAreas() {
		return Areas;
	}

	protected boolean addInspector (Inspector inspector) {
		for (int i = 0; i < this.inspectors.size(); i++) {
			if(this.inspectors.get(i).equals(inspector))
				return false;
		}
		staticInspector_number++;
		return this.inspectors.add(inspector);
	}
	
	protected boolean addResturant (Restaurant resturant) {
		for (int i = 0; i < this.restaurants.size(); i++) {
			if(this.restaurants.get(i).equals(resturant))
				return false;
		}
		staticRestaurant_number++;
		return this.restaurants.add(resturant);
	}
	
	public boolean setReview (Inspector inspector , Restaurant restaurant , float [] ratings , String opinion) {
		inspector.setReviewToRestaurant(restaurant , ratings , opinion);
		return true;
	}

	public String showAllRestaurants() {
		StringBuffer allRes = new StringBuffer();
		for (Restaurant res : this.restaurants) {
			allRes.append(res.toString()+"\n\n");
		}
		return allRes.toString();
	}
	
	public String showAllInspectoes() {
		StringBuffer allIns = new StringBuffer();
		for (Inspector ins : this.inspectors) {
			allIns.append(ins.toString()+"\n\n");
		}
		return allIns.toString();
	}
	
	public Vector<String> getAllRestaurantNames(){
		Vector<String> allRestaurantNames = new Vector<String>();
		for (Restaurant res : this.restaurants) {
			allRestaurantNames.add(res.getRestaurantName());
		}
		allRestaurantNames.sort(null);
		return allRestaurantNames;
	}
	
	public Vector<String> getAllRestaurantNamesByArea(String Area){
		Vector<String> allRestaurantNames = new Vector<String>();
		for (Restaurant res : this.restaurants) {
			if(res.getRestaurantAddress().getArea().equals(Area))
				allRestaurantNames.add(res.getRestaurantName());
		}
		allRestaurantNames.sort(null);
		return allRestaurantNames;
	}

	public Vector<String> getAllTypes(){
		Vector< String > allTypes = new Vector<String>();
		allTypes.add("Street Food");
		allTypes.add("Cafe");
		allTypes.add("Fast Food");
		allTypes.add("Barbecue");
		allTypes.add("Fish Seafood");
		allTypes.add("Bar");
		allTypes.add("Chef Restaurant");
		allTypes.add("Regular Restaurant");
		return allTypes;
	}

	public Restaurant getRestaurantByName(String restaurantName, String area , String city) {
		Restaurant temp = new Restaurant(restaurantName, area, city, 0, null);
		for (Restaurant rest : this.restaurants) {
			if(rest.equals(temp))
				return rest;
		}
		return null;
	}

	public Inspector getInspectorByID(String name , String last ,String iD)  {
		Inspector temp = null;
		try {
			temp = new Inspector(name, last, iD);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		for (Inspector ins : this.inspectors) {
			if(ins.equals(temp))
				return ins;
		}
		return null;
	}
	
	public FactoryObjects getFactory() {
		if(this.factory == null)
			this.factory = FactoryObjects.getFactory_Objects();
		return this.factory;
	}

	public Vector<String> getAllCitiesByArea(String area){
		Vector<String> allCities = new Vector<String>();
		for (String s : this.Cities.get(area)) 
			allCities.add(s);
		allCities.sort(null);
		return allCities;
	}

	public Vector<String> getAllRestaurantNamesByAreaAndCity(String area, String city) {
		Vector<String> allRestaurantNames =  new Vector<String>();
		for (Restaurant Res : this.restaurants) {
			if(Res.getRestaurantAddress().getArea().equals(area) && Res.getRestaurantAddress().getCity().equals(city)) {
				allRestaurantNames.add(Res.getRestaurantName());
			}
		}
		allRestaurantNames.sort(null);
		return allRestaurantNames;
	}
	
	public void getRatingStatic(RatingRestaurant ratingRestaurant) {
		this.Rating_Restaurant = ratingRestaurant;
	}
	
	public void exit() throws IOException ,NotSerializableException ,FileNotFoundException{
		ObjectOutputStream outFile;
		outFile = new ObjectOutputStream(new FileOutputStream("C:\\Users\\nissa\\eclipse-workspace\\RatingRastaurantProject\\NissanProject.txt"));
		outFile.writeObject(this);
		outFile.close();
	}


	public Restaurant getRestaurantByName(String restaurantName, String area) {
		Restaurant temp = new Restaurant(restaurantName, area, null, 0, null);
		for (Restaurant rest : this.restaurants) {
			if(rest.getRestaurantAddress().getArea().equals(temp.getRestaurantAddress().getArea())) {
				if(rest.getRestaurantName().equals(temp.getRestaurantName()) )
					return rest;
			}
		}
		return null;
	}
	

	public void addNewArea(String area) {
		for (String string : this.Areas) {
			if(string.equalsIgnoreCase(area))
				return;
		}
		this.Areas.add(area);
		this.Cities.put(area, new Vector<String>());
		
	}

	public void addNewCity(String area, String city) {
		for (String string : this.Areas) {
			if(string.equalsIgnoreCase(area))
				area = string;
		}
		Vector<String> c = this.Cities.get(area);
		c.add(city);
	}

	
}
