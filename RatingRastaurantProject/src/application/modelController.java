package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.Vector;

import application.model.Inspector;
import application.model.RatingRestaurant;
import application.model.Restaurant;
import application.model.interfaces.RatingRestaurantUIEventListener;

public class modelController implements RatingRestaurantUIEventListener{
	
	private transient RatingRestaurant theModel;
	
	public modelController(RatingRestaurant theModel) {
		this.theModel = theModel;
	}

	@Override
	public Vector<String> getTypes() {
		return  theModel.getAllTypes();
	}

	@Override
	public Vector<String> getAreas() {
		return theModel.getAreas();
	}

	@Override
	public boolean addRestaurantFromUI(String name, String area, String city, String houseNumber ,String type) {
		return theModel.getFactory().addRestaurantToApp(theModel, name, area, city, houseNumber, type);
	}

	@Override
	public boolean addInspectorFromUI(String name, String last, String iD) throws Exception {
		return theModel.getFactory().addInspectorToApp(theModel , name , last , iD);
	}

	@Override
	public Vector<String> getAllRestaurantsUI() {
		return theModel.getAllRestaurantNames();
	}

	@Override
	public Vector<String> getAllRestaurantsUIByArea(String area) {
		return theModel.getAllRestaurantNamesByArea(area);
	}

	@Override
	public Vector<String> getAllCitiesUIByArea(String area) {
		return theModel.getAllCitiesByArea(area);
	}

	@Override
	public Inspector getInspector(String name, String last, String id) {
		return theModel.getInspectorByID(name , last , id);
	}

	@Override
	public void addReviewFromUI(Inspector inspect, Restaurant resta, float[] ratings, String opinion) {
		theModel.setReview(inspect, resta , ratings , opinion);
	}

	@Override
	public Vector<String> getAllRestaurantsUIByCityANDArea(String area, String city) {
		return theModel.getAllRestaurantNamesByAreaAndCity(area , city);
	}

	@Override
	public String showAllRestaurantsReview() {
		return theModel.showAllRestaurants();
	}

	@Override
	public String showAllInspectors() {
		return theModel.showAllInspectoes();
	}

	@Override
	public void exit() throws NotSerializableException, FileNotFoundException, IOException {
		theModel.exit();
		
	}

	@Override
	public Restaurant getRestaurant(String restaurantName, String area) {
		return theModel.getRestaurantByName(restaurantName, area);
	}
	
	@Override
	public Restaurant getRestaurant(String resName, String area, String city) {
		return theModel.getRestaurantByName(resName , area , city);
	}

	@Override
	public void addAreaToModel(String area) {
		theModel.addNewArea(area);
	}

	@Override
	public void addCityToArea(String area, String city) {
		theModel.addNewCity(area , city);
		
	}

	
	

	

}
