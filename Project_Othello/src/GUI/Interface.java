package GUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import Game.*;
import PlayersType.EasyAI;
import PlayersType.HardAI;
import PlayersType.IntermediateAI;
import PlayersType.Joueur;
import PlayersType.Player;

public class Interface extends Stage {
	//attributes
	private Partie partie;
	private MenuAI menuA;
	private GameTypeMenu menuB;
	private ChoosePseudosMenu menuC;
	
	//constructor
	public Interface() {
		//initialisation des menus
		this.menuA = new MenuAI(this);
		this.menuB = new GameTypeMenu();
		this.menuC = new ChoosePseudosMenu(this);
		
		//initialisation des tailles
		this.setMinHeight(400);
		this.setMinWidth(500);
		this.setHeight(900);
		this.setWidth(1200);
		
		// AJOUT DES ACTIONS SUR LES BOUTONS DES MENUS
		
		//actions menu du choix des pseudos
		this.menuC.getValider().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				List<Player> joueurs = new ArrayList<Player>();
				Joueur player1 = new Joueur(Couleur.Noir, menuC.getPseudo1().getText());
				Joueur player2 = new Joueur(Couleur.Blanc, menuC.getPseudo2().getText());
				joueurs.add(player1);
				joueurs.add(player2);
				Partie p = new Partie(joueurs, menuC.getInterf());
				p.getJoueurs().get(0).setpartie(p);
				p.getJoueurs().get(1).setpartie(p);
				partie = p;
				setScene(new Scene(new Plate(partie, menuC.getInterf())));
			}
		});
		
		//actions menu d'IA
		this.menuA.getEasy().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				List<Player> joueurs = new ArrayList<Player>();
				Joueur player1 = new Joueur(Couleur.Noir, menuA.getPseudo().getText());
				EasyAI player2 = new EasyAI(Couleur.Blanc, "IA omega");
				joueurs.add(player1);
				joueurs.add(player2);
				Partie p = new Partie(joueurs, menuA.getInterf());
				p.getJoueurs().get(0).setpartie(p);
				p.getJoueurs().get(1).setpartie(p);
				partie = p;
				setScene(new Scene(new Plate(p, menuA.getInterf())));
			}
			
		});
		this.menuA.getInter().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				List<Player> joueurs = new ArrayList<Player>();
				Joueur player1 = new Joueur(Couleur.Noir, menuA.getPseudo().getText());
				IntermediateAI player2 = new IntermediateAI(Couleur.Blanc, "IA Beta");
				joueurs.add(player1);
				joueurs.add(player2);
				Partie p = new Partie(joueurs, menuA.getInterf());
				p.getJoueurs().get(0).setpartie(p);
				p.getJoueurs().get(1).setpartie(p);
				partie = p;
				setScene(new Scene(new Plate(p, menuA.getInterf())));
			}
			
		});
		this.menuA.getHard().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				List<Player> joueurs = new ArrayList<Player>();
				Joueur player1 = new Joueur(Couleur.Noir, menuA.getPseudo().getText());
				HardAI player2 = new HardAI(Couleur.Blanc, "IA Alpha");
				joueurs.add(player1);
				joueurs.add(player2);
				Partie p = new Partie(joueurs, menuA.getInterf());
				p.getJoueurs().get(0).setpartie(p);
				p.getJoueurs().get(1).setpartie(p);
				partie = p;
				setScene(new Scene(new Plate(p, menuA.getInterf())));
			}
			
		});
		
		//actions menu solo ou multi
		this.menuB.getSolo().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				setScene(new Scene(menuA));
			}
		});
		this.menuB.getMulti().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				setScene(new Scene(menuC));
			}
		});
		
		this.setScene(new Scene(menuB));
	}
	
	//getter
	public Partie getPartie(){ // renvoie la partie en cours
		return this.partie;
	}
	
	//methods
	public void setGameOver() {//place le menu de fin
		//initialisation d'un menu gameOver
		GameOver menuD = new GameOver(this.partie, this);
		
		//REMISE EN PLACE DES BOUTONS POUR CHAQUE MENU
		menuD.getMenu().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Interface i2 = new Interface();
				menuA = new MenuAI(i2);
				menuB = new GameTypeMenu();
				menuC = new ChoosePseudosMenu(i2);
				
				menuC.getValider().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						List<Player> joueurs = new ArrayList<Player>();
						Joueur player1 = new Joueur(Couleur.Noir, menuC.getPseudo1().getText());
						Joueur player2 = new Joueur(Couleur.Blanc, menuC.getPseudo2().getText());
						joueurs.add(player1);
						joueurs.add(player2);
						Partie p = new Partie(joueurs, menuC.getInterf());
						p.getJoueurs().get(0).setpartie(p);
						p.getJoueurs().get(1).setpartie(p);
						partie = p;
						setScene(new Scene(new Plate(p, menuC.getInterf())));
					}
				});
				
				//actions menu d'IA
				menuA.getEasy().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						List<Player> joueurs = new ArrayList<Player>();
						Joueur player1 = new Joueur(Couleur.Noir, menuA.getPseudo().getText());
						EasyAI player2 = new EasyAI(Couleur.Blanc, "IA easy");
						joueurs.add(player1);
						joueurs.add(player2);
						Partie p = new Partie(joueurs, menuA.getInterf());
						p.getJoueurs().get(0).setpartie(p);
						p.getJoueurs().get(1).setpartie(p);
						partie = p;
						setScene(new Scene(new Plate(p, menuA.getInterf())));
					}
				});
				menuA.getInter().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						List<Player> joueurs = new ArrayList<Player>();
						Joueur player1 = new Joueur(Couleur.Noir, menuA.getPseudo().getText());
						IntermediateAI player2 = new IntermediateAI(Couleur.Blanc, "IA inter");
						joueurs.add(player1);
						joueurs.add(player2);
						Partie p = new Partie(joueurs, menuA.getInterf());
						p.getJoueurs().get(0).setpartie(p);
						p.getJoueurs().get(1).setpartie(p);
						partie = p;
						setScene(new Scene(new Plate(p, menuA.getInterf())));
					}
				});
				menuA.getHard().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						List<Player> joueurs = new ArrayList<Player>();
						Joueur player1 = new Joueur(Couleur.Noir, menuA.getPseudo().getText());
						HardAI player2 = new HardAI(Couleur.Blanc, "IA Alpha");
						joueurs.add(player1);
						joueurs.add(player2);
						Partie p = new Partie(joueurs, menuA.getInterf());
						p.getJoueurs().get(0).setpartie(p);
						p.getJoueurs().get(1).setpartie(p);
						partie = p;
						setScene(new Scene(new Plate(p, menuA.getInterf())));
					}
					
				});
				
				//actions menu solo ou multi
				menuB.getSolo().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						setScene(new Scene(menuA));
					}
				});
				menuB.getMulti().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						setScene(new Scene(menuC));
					}
				});
				setScene(new Scene(menuB));
			}
		});
		this.setScene(new Scene(menuD));
	}
}