package application.model;

import java.io.Serializable;
import java.util.InputMismatchException;
import application.model.enums.resType;

public class FactoryObjects implements Serializable{
	private static FactoryObjects Factory_Objects = null;
	
	private FactoryObjects() {}
	
	/// Design pattern singleton /*only one factory
	public static FactoryObjects getFactory_Objects() {
		if(Factory_Objects == null)
			Factory_Objects = new FactoryObjects();
				
		return Factory_Objects;
	}
	
		
	public boolean addRestaurantToApp(RatingRestaurant app , String RasturantName , 
			String area , String city , String num , String type) {
		int houseNumber = chckIfIsOnlyNumbers(num);
		if (RasturantName != null && !RasturantName.equals(" ")  && houseNumber != -1){
			String s = type.replace(" ", "");
			resType restaurantType = resType.valueOf(s);
			return app.addResturant(new Restaurant(RasturantName, area, city, houseNumber, restaurantType));
		}
		return false;
		
	}
	public boolean addInspectorToApp(RatingRestaurant app, String name, String last, String iD) throws Exception {
		if(checkIfIsOnlyChars(name) && checkIfIsOnlyChars(last) && checkID(iD) != -1)
			return app.addInspector(new Inspector(name, last, iD));
		return false;
	}
	private int checkID(String iD) {
		if(iD.length() != 9)
			return -1;
		return chckIfIsOnlyNumbers(iD);
	}

	private int chckIfIsOnlyNumbers(String num) {
		if(num == " ")
			return -1;
		int houseNumnber = 0;
		for (int index = 0; index < num.length(); index++) {
			if(num.charAt(index) < '0' || num.charAt(index) > '9')
				return -1;
			houseNumnber = (int) (houseNumnber + Math.pow(10, num.length()-index-1)*(num.charAt(index) - 48));
		}
		return houseNumnber;
	}

	private boolean checkIfIsOnlyChars(String str) {
		if(str == " " || str == null)
			return false;
		for (int index = 0; index < str.length() ; index++) {
			char temp = str.charAt(index);
			if( ( temp < 'A' || (temp >'Z' && temp < 'a') || temp >'z' ) && temp != ' ')
				return false;
		}
		return true;
	}

	
}

