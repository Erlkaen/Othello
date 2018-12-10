package GUI;

import java.io.InputStream;

import Game.Partie;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameOver extends VBox{
	//attributes
	private Partie p;
	private Button menu = new Button("Menu Principal");
	private Interface interf;

	//constructor
	public GameOver(Partie p, Interface interf) {
		this.p = p;
		this.interf = interf;
		this.setStyle("-fx-alignment: center;");

		//general VBox options
		VBox box1 = new VBox();
		VBox box2 = new VBox();
		VBox.setVgrow(box1, Priority.ALWAYS);
		VBox.setVgrow(box2, Priority.ALWAYS);
		this.setStyle("-fx-alignment:center");
		
		//Image VBox options		
		Class<?> clazz = GameOver.class; 
		InputStream input = clazz.getResourceAsStream("Othello.png");
		Image image = new Image(input);
		ImageView view = new ImageView(image);
		view.setPreserveRatio(true);
		view.fitWidthProperty().bind(this.widthProperty());
		box1.getChildren().addAll(view);
		this.getChildren().add(box1);
		
		//VBox 2 Options
		box2.setStyle("-fx-alignment: center;");
		box2.setPrefHeight(40);
		if(this.p.isEgality()) {
			Text t = new Text("La partie se termine par une egalite !");
			box2.getChildren().add(t);
		}else if(this.p.win() == this.p.getJoueurs().get(0)) {
			Text t2 = new Text("Le joueur " + this.p.getJoueurs().get(0).getPseudo() + " a gagne la partie.");
			box2.getChildren().add(t2);
		}else {
			Text t3 = new Text("Le joueur " + this.p.getJoueurs().get(1).getPseudo() + " a gagne la partie.");
			box2.getChildren().add(t3);
		}
		this.getChildren().add(this.menu);
		this.getChildren().add(box2);
	}
	
	//getters
	public Button getMenu() {
		return this.menu;
	}
	public Interface getInterf() {
		return this.interf;
	}
	
}
