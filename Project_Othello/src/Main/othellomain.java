package Main;

import javafx.application.Application;
import javafx.stage.Stage;

import GUI.*;

public class othellomain extends Application{

	public static void main(String[] args) {
        Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Othello"); //nomme la fenetre "othello"
		// CREATION DE L'INTERFACE
		Interface i = new Interface();
		// CREATION DE L'INTERFACE
		
	    
		// AFFICHAGE DE LA FENETRE DE JEU
		i.show();
		// AFFICHAGE DE LA FENETRE DE JEU
	}
}
