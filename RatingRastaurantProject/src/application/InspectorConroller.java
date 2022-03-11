package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import application.model.Inspector;
import application.model.RatingRestaurant;
import application.model.Restaurant;
import application.model.interfaces.RatingRestaurantUIEventListener;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InspectorConroller implements Initializable {
	private transient RatingRestaurantUIEventListener control = new modelController(RatingRestaurant.getRating_Restaurant());
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sliderToilet.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				Float temp = (float) sliderToilet.getValue();
				ShowToiletSlide.setText(String.format("%.2f", temp));
			}
		});
		sliderEatAndDrink.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				Float temp = (float) sliderEatAndDrink.getValue();
				ShowEatDriSlide.setText(String.format("%.2f", temp));
			}
		});
		sliderFloor.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				Float temp = (float) sliderFloor.getValue();
				ShowFloorSlide.setText(String.format("%.2f", temp));
			}
		});
		sliderKitchAndBar.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				Float temp = (float) sliderKitchAndBar.getValue();
				ShowKitchenSlide.setText(String.format("%.2f", temp));
			}
		});

	}
				
				
	 @FXML
	    private TextField AreaTextFile;

	    @FXML
	    private Button BaddInspectorButton;

	    @FXML
	    private ComboBox<String> CityCombo1;

	    @FXML
	    private TextField CityTextFile;

	    @FXML
	    private Button ExitButton;

	    @FXML
	    private TextField FirstNameText;

	    @FXML
	    private TextField IDText;

	    @FXML
	    private Button InsertReviewButton;

	    @FXML
	    private TextField InspectorIDText;

	    @FXML
	    private TextField InspectorLastText;

	    @FXML
	    private TextField InspectorNameText;

	    @FXML
	    private TextField LastNameText;

	    @FXML
	    private ComboBox<String> RestaurantCombo;

	    @FXML
	    private Label ShowEatDriSlide;

	    @FXML
	    private Label ShowFloorSlide;

	    @FXML
	    private Label ShowKitchenSlide;

	    @FXML
	    private Label ShowToiletSlide;

	    @FXML
	    private TextArea TextAreaForInfo;

	    @FXML
	    private Button addInspectorButton;

	    @FXML
	    private Pane addInspectorPane;

	    @FXML
	    private Button addNewReviewButton;

	    @FXML
	    private Button addRestaurantButton;

	    @FXML
	    private Pane addRestaurantPane;

	    @FXML
	    private Pane addReviewPane;

	    @FXML
	    private ComboBox<String> areaCombo;

	    @FXML
	    private ComboBox<String> areaComboInAddReviewPane;

	    @FXML
	    private ComboBox<String> cityComboInAddReviewPane;

	    @FXML
	    private ScrollPane detailsPane;

	    @FXML
	    private CheckBox insertAreaCheckBox;

	    @FXML
	    private CheckBox insertCityCheckBox;

	    @FXML
	    private Label massageLable;

	    @FXML
	    private TextArea opinionAboutRestaurantText;

	    @FXML
	    private ComboBox<String> restuarantTypeCombo;

	    @FXML
	    private AnchorPane scenePane;

	    @FXML
	    private TextField setNumberToRestarantText;

	    @FXML
	    private TextField setRestaurantNameText;

	    @FXML
	    private Button showAllInspectprsButton;

	    @FXML
	    private Button showAllReasturantsButton;

	    @FXML
	    private Slider sliderEatAndDrink;

	    @FXML
	    private Slider sliderFloor;

	    @FXML
	    private Slider sliderKitchAndBar;

	    @FXML
	    private Slider sliderToilet;
////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void AddInspectorOnAction(ActionEvent event) {
    	addInspectorPane.setVisible(true);
    	addRestaurantPane.setVisible(false);
    	addReviewPane.setVisible(false);
    	detailsPane.setVisible(false);
    	FirstNameText.clear();
    	LastNameText.clear();
    	IDText.clear();
    	massageLable.setText(null);
    }
    @FXML
    void addInspectorButton(ActionEvent event) throws Exception {
    	String name = FirstNameText.getText();
    	String last = LastNameText.getText();
    	String ID = IDText.getText();
    	if(name.equals("") || last.equals("") || ID.equals("")) {
    		massageLable.setText("Incorrect input");
    		FirstNameText.clear();
        	LastNameText.clear();
        	IDText.clear();
    		return;
    	}
    	boolean res = control.addInspectorFromUI(name , last ,ID);
    	if(res == false)
    		massageLable.setText("Incorrect input\r\n"
    				+ "(ID - 9 numbers only).\nOr inspector exist");
    	else
    		massageLable.setText("The inspector "+name+" was successfully added");
    	FirstNameText.clear();
    	LastNameText.clear();
    	IDText.clear();
    	addInspectorPane.setVisible(false);
    }
////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void AddRestaurantOnAction(ActionEvent event) {
    	addInspectorPane.setVisible(false);
    	addRestaurantPane.setVisible(true);
    	addReviewPane.setVisible(false);
    	detailsPane.setVisible(false);
    	massageLable.setText(null);
    	clearPaneAddRestaurant();
    	getTypeAndAreas();
    }
    private void getTypeAndAreas() {
    	Vector<String> allTypes = getAllTypes();
    	for (String s : allTypes) {
			restuarantTypeCombo.getItems().add(s.toString());
		}
    	Vector<String> allAreas = getAllAreas();
    	for (int index = 0; index < allAreas.size(); index++) {
			areaCombo.getItems().add(allAreas.get(index));
		}
	}
    private void clearPaneAddRestaurant() {
    	setRestaurantNameText.clear();
    	restuarantTypeCombo.getItems().clear();
    	restuarantTypeCombo.setValue(null);
    	restuarantTypeCombo.setPromptText("Select Type");
    	areaCombo.getItems().clear();
    	areaCombo.setValue(null);
    	areaCombo.setPromptText("Select Area");
    	CityCombo1.getItems().clear();
    	CityCombo1.setValue(null);
    	CityCombo1.setPromptText("Select City");
    	setNumberToRestarantText.clear();
    	insertAreaCheckBox.setSelected(false);
    	insertCityCheckBox.setSelected(false);
    	AreaTextFile.setText(null);
    	CityTextFile.setText(null);
    	AreaTextFile.setPromptText("Enter an area");
    	CityTextFile.setPromptText("Enter a city");
    	areaCombo.setDisable(false);
		AreaTextFile.setDisable(true);
		CityCombo1.setDisable(false);
		CityTextFile.setDisable(true);
		insertCityCheckBox.setDisable(false);
    	
    }
    
    @FXML
    void SelectCityByArea(ActionEvent event) {
    	CityCombo1.getItems().clear();
    	CityCombo1.setValue(null);
    	CityCombo1.setPromptText("Select City");
    	if(areaCombo.getValue() == null)
    		return;
    	Vector <String> allCitiesByArea = getAllCitiesByArea(areaCombo.getValue());
    	for (String s : allCitiesByArea) {
			CityCombo1.getItems().add(s);
		}
    }

    @FXML
    void addRestaurantButton(ActionEvent event) {
    	String name = setRestaurantNameText.getText();
    	String type = restuarantTypeCombo.getValue();
    	String area , city; 
    	if(insertAreaCheckBox.isSelected()) {
    		area = AreaTextFile.getText();
    		if( area == null || area.equals(" ") ) {
        		massageLable.setText("Incorrect input");
        		clearPaneAddRestaurant();
        		getTypeAndAreas();
        		return;
        	}
    		control.addAreaToModel(area);
    	}
    	else
        	area = areaCombo.getValue();
    	if(insertAreaCheckBox.isSelected() || insertCityCheckBox.isSelected()) {
    		city = CityTextFile.getText();
    		if(city == null || city.equals(" ")) {
        		massageLable.setText("Incorrect input");
        		clearPaneAddRestaurant();
        		getTypeAndAreas();
        		return;
        	}
    		control.addCityToArea(area , city);
    	}
    	else
    		city = CityCombo1.getValue();
    	String houseNumber = setNumberToRestarantText.getText();
    	if(name.equals("") || type == null || area == null || city == null || city.equals("") || houseNumber.equals("")) {
    		massageLable.setText("Incorrect input");
    		clearPaneAddRestaurant();
    		getTypeAndAreas();
    		return;
    	}
    	boolean res = control.addRestaurantFromUI(name, area, city, houseNumber, type);
    	if(res == false)
    		massageLable.setText("Incorrect input\r\n"
    				+ "House number - numbers only.\nOr restaurant exist");
    	else
    		massageLable.setText("The restaurant "+name+" was successfully added");
    	
    	clearPaneAddRestaurant();
    	addRestaurantPane.setVisible(false);
    }

    @FXML
    void handleInsertAreaCheckBox(ActionEvent event) {
    	if(insertAreaCheckBox.isSelected()) {
    		areaCombo.setDisable(true);
    		AreaTextFile.setDisable(false);
    		CityCombo1.setDisable(true);
    		CityTextFile.setDisable(false);
    		insertCityCheckBox.setDisable(true);
    	}
    	else {
    		areaCombo.setDisable(false);
    		AreaTextFile.setDisable(true);
    		CityCombo1.setDisable(false);
    		CityTextFile.setDisable(true);
    		insertCityCheckBox.setDisable(false);
    	}
    }
    
    @FXML
    void handleInsertCityCheckBox(ActionEvent event) {
    	if(insertCityCheckBox.isSelected()) {
    		CityCombo1.setDisable(true);
    		CityTextFile.setDisable(false);
    	}
    	else {
    		CityCombo1.setDisable(false);
    		CityTextFile.setDisable(true);
    	}
    }
/////////////////////////////////////////////////////////////////////////////////////////////    
    
    private Vector<String> getAllAreas() {
    	return control.getAreas();
	}
    private Vector<String> getAllTypes() {
    	return control.getTypes();
	}
////////////////////////////////////////////////////////////////////////////////////////////
    
	@FXML
    void AddReviewOnAction(ActionEvent event) {
		addInspectorPane.setVisible(false);
    	addRestaurantPane.setVisible(false);
    	addReviewPane.setVisible(true);
    	detailsPane.setVisible(false);
    	massageLable.setText(null);
		clearAddReview();
		Vector<String> allAreas = getAllAreas();
    	for (int index = 0; index < allAreas.size(); index++) {
    		areaComboInAddReviewPane.getItems().add(allAreas.get(index));
		}
    	cityComboInAddReviewPane.getItems().clear();
    }	
	private void clearAddReview() {
    	InspectorNameText.clear();
    	InspectorNameText.setPromptText("Inspector name");
    	InspectorLastText.clear();
    	InspectorLastText.setPromptText("Inspector last name");
    	InspectorIDText.clear();
    	InspectorIDText.setPromptText("Inspector ID");
    	areaComboInAddReviewPane.getItems().clear();
    	areaComboInAddReviewPane.setValue(null);
    	areaComboInAddReviewPane.setPromptText("Area");
    	cityComboInAddReviewPane.getItems().clear();
    	cityComboInAddReviewPane.setValue(null);
    	cityComboInAddReviewPane.setPromptText("City");
    	RestaurantCombo.getItems().clear();
    	RestaurantCombo.setValue(null);
    	RestaurantCombo.setPromptText("Select Restaurant");
    	sliderToilet.setValue(0);
    	sliderEatAndDrink.setValue(0);
    	sliderFloor.setValue(0);
    	sliderKitchAndBar.setValue(0);
    	opinionAboutRestaurantText.clear();
    	opinionAboutRestaurantText.setPromptText("You can express an opinion about the restaurant here");
	}
    
	@FXML
    void SelectCityByAreaReviewPane(ActionEvent event) {
		cityComboInAddReviewPane.getItems().clear();
		cityComboInAddReviewPane.setValue(null);
		cityComboInAddReviewPane.setPromptText("Select City");
    	if(areaComboInAddReviewPane.getValue() == null)
    		return;
    	Vector <String> allCitiesByArea = getAllCitiesByArea(areaComboInAddReviewPane.getValue());
    	for (String s : allCitiesByArea) {
    		cityComboInAddReviewPane.getItems().add(s);
		}
    	RestaurantCombo.getItems().clear();
    	RestaurantCombo.setValue(null);
    	RestaurantCombo.setPromptText("Select Restaurant");
	}

	@FXML
    void cityReviwOnActionCombo(ActionEvent event) {
		RestaurantCombo.getItems().clear();
		RestaurantCombo.setValue(null);
		RestaurantCombo.setPromptText("Select Restaurant");
		if(cityComboInAddReviewPane.getValue() == null)
    		return;
		Vector <String> allRestaurants = getAllRestaurantsNameByCityAndArea(areaComboInAddReviewPane.getValue(),cityComboInAddReviewPane.getValue());
    	for (String s : allRestaurants) {
    		RestaurantCombo.getItems().add(s);
		}
	}
		
	private Vector<String> getAllRestaurantsNameByCityAndArea(String area, String city) {
		return control.getAllRestaurantsUIByCityANDArea(area , city);
	}
	
	@FXML
    void InsertReviewButton(ActionEvent event) {
		Inspector inspect = control.getInspector(InspectorNameText.getText(),InspectorLastText.getText(),InspectorIDText.getText());
		if(inspect == null) {
			massageLable.setText("The inspector not found!\n(ID - only numbers!)");
			clearAddReview();
			return;
		}
		Restaurant resta = control.getRestaurant(RestaurantCombo.getValue(),  areaComboInAddReviewPane.getValue(), cityComboInAddReviewPane.getValue());
		float [] ratings = {(float)sliderToilet.getValue() , (float) sliderEatAndDrink.getValue() , 
				(float)sliderFloor.getValue() , (float) sliderKitchAndBar.getValue()};
		
		String opinion = inspect.getFirstName()+" "+inspect.getLastName()+":\n"+opinionAboutRestaurantText.getText();
		
		control.addReviewFromUI(inspect , resta , ratings , opinion);
		clearAddReview();
		addReviewPane.setVisible(false);
	}
///////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void ShowAllInspectorsOnAction(ActionEvent event) {
    	addInspectorPane.setVisible(false);
    	addRestaurantPane.setVisible(false);
    	addReviewPane.setVisible(false);
    	detailsPane.setVisible(true);
    	massageLable.setText(null);
    	TextAreaForInfo.clear();
    	String info = control.showAllInspectors();
    	TextAreaForInfo.setText(info);

    }
///////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void ShowAllRestaurantsOnAction(ActionEvent event) {
    	addInspectorPane.setVisible(false);
    	addRestaurantPane.setVisible(false);
    	addReviewPane.setVisible(false);
    	detailsPane.setVisible(true);
    	massageLable.setText(null);
    	TextAreaForInfo.clear();
    	String info = control.showAllRestaurantsReview();
    	TextAreaForInfo.setText(info);
    }
    
    private Vector<String> getAllCitiesByArea(String area) {
		return control.getAllCitiesUIByArea(area);
	}
///////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void exitButtonOnAction(ActionEvent event) throws Exception {
    	addInspectorPane.setVisible(false);
    	addRestaurantPane.setVisible(false);
    	addReviewPane.setVisible(false);
    	detailsPane.setVisible(false);
    	massageLable.setText(null);
    	control.exit();
    	Stage stage = (Stage) scenePane.getScene().getWindow();
    	System.out.println("Log Out ..Bye Bye");
    	stage.close();
    }


}


