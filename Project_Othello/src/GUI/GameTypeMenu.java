package GUI;


import java.io.InputStream;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GameTypeMenu extends VBox{
	//attributes
	private Button solo = new Button("Solo");
	private Button multi = new Button("Multijoueur");
	
	//constructor
	public GameTypeMenu() {
		//general VBox options
		VBox box1 = new VBox();
		VBox box2 = new VBox();
		VBox.setVgrow(box1, Priority.ALWAYS);
		VBox.setVgrow(box2, Priority.ALWAYS);
		box1.setStyle("-fx-alignment:center");
		
		//Image VBox options
		Class<?> clazz = GameTypeMenu.class; 
		InputStream input = clazz.getResourceAsStream("Othello.png");
		Image image = new Image(input);
		ImageView view = new ImageView(image);
		view.setPreserveRatio(true);
		view.fitWidthProperty().bind(this.widthProperty());
		box1.getChildren().addAll(view);
		this.getChildren().add(box1);
		
		//Buttons VBox options
		box2.setPrefHeight(600);
		box2.setSpacing(40);
		VBox.setVgrow(this.solo, Priority.ALWAYS);
		VBox.setVgrow(this.multi, Priority.ALWAYS);
		this.solo.setMaxSize(300, 150);
		this.multi.setMaxSize(300, 150);
		box2.getChildren().add(solo);
		box2.getChildren().add(multi);
		box2.setStyle("-fx-alignment: center;");

		this.getChildren().add(box2);	
	}
	
	//getters
	public Button getSolo() {
		return this.solo;
	}
	public Button getMulti() {
		return this.multi;
	}
}
