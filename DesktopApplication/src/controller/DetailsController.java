package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utility.Person;

public class DetailsController implements Initializable{
	
	@FXML
	Label name, lastName, gender, age, userName, email, city;
	@FXML
	ImageView imageView;
	
	Person person;
	
	public void show(Person person) {
		this.person = person;
		
		name.setText(person.getFirstName());
		lastName.setText(person.getLastName());
		gender.setText(person.getGender());
		age.setText(String.valueOf(person.getAge()));
		userName.setText(person.getUserName());
		email.setText(person.getEmail());
		city.setText(person.getCity());
		
		Image img = new Image(person.getMediumPhoto());
		imageView.setImage(img);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		
	}

}
