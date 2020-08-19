package controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utility.Person;

public class MainController implements Initializable{

	@FXML
	ListView<Person> lvMainList;	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// connect and make a request for 20 users
		try {
			URL url = new URL("https://randomuser.me/api/?results=20");
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			Scanner scanner = new Scanner(url.openStream());
			String inline = "";
			
			while(scanner.hasNext()){
				inline += scanner.nextLine();
			}
			
			scanner.close();
			
			// got json object
			JSONObject object = new JSONObject(inline);
			
			// array json object
			JSONArray arr = object.getJSONArray("results");
			
			ArrayList<JSONObject> arrayList = new ArrayList<>(arr.length());
			for(int i = 0; i < arr.length(); i++){
			    arrayList.add(arr.getJSONObject(i));
			}
			
			// get the data 
			for(JSONObject exist : arrayList) {
				
				String first = exist.getJSONObject("name").getString("first");
				String last = exist.getJSONObject("name").getString("last");
				Integer age = exist.getJSONObject("dob").getInt("age");
				String city = exist.getJSONObject("location").getString("city");
				String email = exist.get("email").toString();
				String gender = exist.get("gender").toString();
				String userName = exist.getJSONObject("login").getString("username");
				String thumbnail = exist.getJSONObject("picture").getString("thumbnail");
				String photo = exist.getJSONObject("picture").getString("large");
				
				Person person = new Person(first, last, age, city, email, thumbnail, photo, gender, userName);
				
				lvMainList.getItems().add(person);
				
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// set image and name on item
		lvMainList.setCellFactory(param -> new ListCell<Person>() {			
			private ImageView imageView = new ImageView();
			@Override
            public void updateItem(Person person, boolean empty) {
				super.updateItem(person, empty);
				
				if (empty) {
                    setText(null);
                    setGraphic(null);
                }else {
                	Image img = new Image(person.getPhoto());
                	imageView.setImage(img);
                	setText(person.getFirstName());
                    setGraphic(imageView);
                }
			}
		});
		
		// event list view
		lvMainList.setOnMouseClicked(event -> {
			if(event.getClickCount() == 1) {
				Person person = lvMainList.getSelectionModel().getSelectedItem();
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/DetailsView.fxml"));
					AnchorPane pane = fxmlLoader.load();
					
					DetailsController detailsController = fxmlLoader.getController();
					detailsController.show(person);
					
					Scene scene = new Scene(pane);
					
					Stage stage = new Stage();
					stage.initStyle(StageStyle.DECORATED);
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.getIcons().add(new Image("/img/details.png"));
					stage.setTitle("Details");
					stage.setScene(scene);
					stage.showAndWait();					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
