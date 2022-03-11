package application.model.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.Vector;

import application.model.Inspector;
import application.model.Restaurant;

public interface RatingRestaurantUIEventListener {


	Vector<String> getTypes();

	Vector<String> getAreas();

	boolean addRestaurantFromUI(String name, String area, String city, String houseNumber ,String type);

	boolean addInspectorFromUI(String name, String last, String iD) throws Exception;
	
	Vector<String> getAllRestaurantsUI();


	Vector<String> getAllRestaurantsUIByArea(String area);

	Vector<String> getAllCitiesUIByArea(String area);

	Inspector getInspector(String name, String last, String id);

	Restaurant getRestaurant(String resName, String area, String city);

	void addReviewFromUI(Inspector inspect, Restaurant resta, float[] ratings, String opinion);

	Vector<String> getAllRestaurantsUIByCityANDArea(String area, String city);

	String showAllRestaurantsReview();

	String showAllInspectors();

	void exit() throws NotSerializableException, FileNotFoundException, IOException;

	Restaurant getRestaurant(String value, String value2);

	void addAreaToModel(String area);

	void addCityToArea(String area, String city);

}
