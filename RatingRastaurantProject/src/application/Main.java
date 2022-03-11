package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import application.model.RatingRestaurant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application implements Serializable{
	private ObjectInputStream inFile; ///3
	public RatingRestaurant ratingRestaurant;
	
	public void readFile() throws IOException, ClassNotFoundException {
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\nissa\\eclipse-workspace\\RatingRastaurantProject\\NissanProject.txt");
			inFile =  new ObjectInputStream (file);
			ratingRestaurant = (RatingRestaurant)inFile.readObject();
			ratingRestaurant.getRatingStatic((ratingRestaurant));
			if(ratingRestaurant.getInspectors().size() != 0)
				ratingRestaurant.staticInspector_number = ratingRestaurant.getInspectors().size() + 1;
			if(ratingRestaurant.getRestaurants().size() != 0)
				ratingRestaurant.staticRestaurant_number = ratingRestaurant.getRestaurants().size() + 1;
			inFile.close();
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			File myFile = new File ("C:\\Users\\nissa\\eclipse-workspace\\RatingRastaurantProject\\NissanProject.txt");
			myFile.createNewFile();
			ratingRestaurant = RatingRestaurant.getRating_Restaurant();
			FileInputStream file = new FileInputStream(myFile);
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception ,IOException,
	NotSerializableException , FileNotFoundException , ClassNotFoundException {
		readFile();
		Stage prStage =  new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Viewer.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Parent root2 = FXMLLoader.load(getClass().getResource("Inspector.fxml"));
			Scene scene2 = new Scene(root2);
			prStage.setScene(scene2);
			prStage.show();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}