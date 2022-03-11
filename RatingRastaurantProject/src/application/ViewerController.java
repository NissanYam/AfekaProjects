package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import application.model.RatingRestaurant;
import application.model.Restaurant;
import application.model.enums.SanitationLevel;
import application.model.interfaces.RatingRestaurantUIEventListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ViewerController implements Initializable{
	private transient RatingRestaurantUIEventListener control =
			new modelController(RatingRestaurant.getRating_Restaurant());

	@FXML
    private ComboBox <String> AreaCombo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Vector<String> area = control.getAreas();
		for (String string : area) {
			AreaCombo.getItems().add(string);
		}
	}
	
    @FXML
    private Pane DetailsPane;

    @FXML
    private Text EetAndDrinkUtelText;

    @FXML
    private Text FloorCleaningText;

    @FXML
    private TextArea InfoAboutRes;

    @FXML
    private Text KitchenAndBarCleaning;

    @FXML
    private Text RestaurantAddressText;

    @FXML
    private ComboBox<String> RestaurantCombo;

    @FXML
    private Button SearchButton;

    @FXML
    private Pane SearchPane;

    @FXML
    private Text ToiletCleaningText;

    @FXML
    private Pane TopPane;

    @FXML
    private ComboBox<String> cityCombo;

    @FXML
    private Label message;

    @FXML
    private Text restaurantNameText;

    @FXML
    private ImageView star1;

    @FXML
    private ImageView star2;

    @FXML
    private ImageView star3;

    @FXML
    private ImageView star4;

    @FXML
    private Text totalRatingText;
    
    @FXML
    private ImageView A;
    @FXML
    private ImageView B;
    @FXML
    private ImageView C;
    @FXML
    private ImageView D;
    
    @FXML
    private Button refreshedButton;
    
    

    @FXML
    void AreaComboOnAction(ActionEvent event) {
    	cityCombo.getItems().clear();
    	cityCombo.setValue(null);
    	cityCombo.setPromptText("City");
    	if(AreaCombo.getValue() == null)
    		return;
    	Vector< String > cities = control.getAllCitiesUIByArea(AreaCombo.getValue());
    	for (String s : cities) {
    		cityCombo.getItems().add(s);
		}
    	RestaurantCombo.getItems().clear();
    	RestaurantCombo.setValue(null);
    	RestaurantCombo.setPromptText("Restaurant");
    	Vector<String> res = control.getAllRestaurantsUIByArea(AreaCombo.getValue());
    	for (String string : res) {
			RestaurantCombo.getItems().add(string);
		}

    }
    
    @FXML
    void cityComboOnAction(ActionEvent event) {
    	RestaurantCombo.getItems().clear();
    	RestaurantCombo.setValue(null);
    	RestaurantCombo.setPromptText("Restaurant");
    	if(cityCombo.getValue() == null || AreaCombo.getValue() == null) 
    		return;
    	Vector<String> res = control.getAllRestaurantsUIByCityANDArea(AreaCombo.getValue(), cityCombo.getValue());
    	for (String string : res) {
			RestaurantCombo.getItems().add(string);
		}
    }

	@FXML
    void SearchButtonOnAction(ActionEvent event) {
		Restaurant temp ;
		String a ,b,c;
		if(AreaCombo.getValue() == null) {
			message.setText("Enter area!");
			clearAll();
		}
		if(RestaurantCombo.getValue() == null) {
			message.setText("Enter restaurant!");
			clearAll();
		}
		if(cityCombo.getValue() == null) {
			a = AreaCombo.getValue();
			b = RestaurantCombo.getValue();
			temp = control.getRestaurant(RestaurantCombo.getValue(), AreaCombo.getValue());
		}
		else {
			c = cityCombo.getValue();
			temp = control.getRestaurant(RestaurantCombo.getValue(), AreaCombo.getValue()
					, cityCombo.getValue());
		}
		if(temp == null)
			message.setText("The restaurant does not find");
		else {
			message.setText(null);
			restaurantNameText.setText(temp.getRestaurantName() +" ("+temp.getResturantType().toString()+")");
			RestaurantAddressText.setText(temp.getRestaurantAddress().getArea()+" ,"+temp.getRestaurantAddress().getCity()+" ,"+temp.getRestaurantAddress().getNumber());
			totalRatingText.setText(""+temp.getRatings()[0].getAveRate());
			ToiletCleaningText.setText(""+temp.getRatings()[1].getAveRate());
			EetAndDrinkUtelText.setText(""+temp.getRatings()[2].getAveRate());
			FloorCleaningText.setText(""+temp.getRatings()[3].getAveRate());
			KitchenAndBarCleaning.setText(""+temp.getRatings()[4].getAveRate());
			InfoAboutRes.setText(temp.getAllOpinions());
			star(temp.getLevel());
			
		}
    }
	
	@FXML
	public void clearAll() {
		restaurantNameText.setText(null);
		RestaurantAddressText.setText(null);
		totalRatingText.setText(null);
		ToiletCleaningText.setText(null);
		EetAndDrinkUtelText.setText(null);
		FloorCleaningText.setText(null);
		KitchenAndBarCleaning.setText(null);
		InfoAboutRes.setText(null);
		AreaCombo.setValue(null);
		AreaCombo.getItems().clear();
		AreaCombo.setPromptText("Area");
		cityCombo.setValue(null);
		cityCombo.setPromptText("City");
		RestaurantCombo.setValue(null);
		RestaurantCombo.setPromptText("Restaurant");
		
		Vector<String> area = control.getAreas();
		for (String string : area) {
			AreaCombo.getItems().add(string);
		}
		
	}

	private void star(SanitationLevel level) {
		if(level == SanitationLevel.A) {
			star1.setVisible(true);
			star2.setVisible(true);
			star3.setVisible(true);
			star4.setVisible(true);
			A.setVisible(true);
			B.setVisible(false);
			C.setVisible(false);
			D.setVisible(false);
		}
		else if(level == SanitationLevel.B) {
			star1.setVisible(true);
			star2.setVisible(true);
			star3.setVisible(true);
			star4.setVisible(false);
			A.setVisible(false);
			B.setVisible(true);
			C.setVisible(false);
			D.setVisible(false);
		}
		else if(level == SanitationLevel.C) {
			star1.setVisible(true);
			star2.setVisible(true);
			star3.setVisible(false);
			star4.setVisible(false);
			A.setVisible(false);
			B.setVisible(false);
			C.setVisible(true);
			D.setVisible(false);
		}
		else if(level == SanitationLevel.D) {
			star1.setVisible(true);
			star2.setVisible(false);
			star3.setVisible(false);
			star4.setVisible(false);
			A.setVisible(false);
			B.setVisible(false);
			C.setVisible(false);
			D.setVisible(true);
		}
		else {
			star1.setVisible(false);
			star2.setVisible(false);
			star3.setVisible(false);
			star4.setVisible(false);
			A.setVisible(false);
			B.setVisible(false);
			C.setVisible(false);
			D.setVisible(false);
		}
	}

    




	

}

