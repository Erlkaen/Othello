package Game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GUI.Plate;
import PlayersType.Joueur;
import PlayersType.Player;

public class PartieTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("----------------------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("----------------------------");
	}

	@Test
	public void testGetJoueurs() {
		Joueur b = new Joueur(Couleur.Noir, "Bob");
		Joueur a = new Joueur(Couleur.Blanc, "Arthur");

		List<Player> j = new ArrayList<Player>();
		Partie p = new Partie(j);
		
		//verification que rien ne soit fait si la liste ne contient pas 2 joueurs
		assertEquals(0, p.getJoueurs().size());
		j.add(a);
		p = new Partie(j);
		assertEquals(0, p.getJoueurs().size());
		
		//verification que la liste correspond
		j.add(b);
		p = new Partie(j);
		assertEquals(j, p.getJoueurs());	
	}
	
	@Test
	public void testGetCase() {
		//initialisation partie
		Joueur b = new Joueur(Couleur.Noir, "Bob");
		Joueur a = new Joueur(Couleur.Blanc, "Arthur");
		List<Player> j = new ArrayList<Player>();
		j.add(a);
		j.add(b);
		Partie p = new Partie(j);
		
		assertEquals(2, p.getCase(2, 3).getX());
		assertEquals(3, p.getCase(2, 3).getY());
	}
	
	@Test
	public void testGetInPlay() {
		//initialisation partie
		Joueur b = new Joueur(Couleur.Noir, "Bob");
		Joueur a = new Joueur(Couleur.Blanc, "Arthur");
		List<Player> j = new ArrayList<Player>();
		j.add(a);
		j.add(b);
		Partie p = new Partie(j);
		
		assertNotNull(p.getInplay());
		assertEquals(b, p.getInplay());
		
		p.changePlayerInPlay();
		
		assertEquals(a, p.getInplay());
	}
	
	@Test
	public void testSetJoueurs() {
		//initialisation partie
		Joueur b = new Joueur(Couleur.Noir, "Bob");
		Joueur a = new Joueur(Couleur.Blanc, "Arthur");
		List<Player> j = new ArrayList<Player>();
		j.add(a);
		j.add(b);
		Partie p = new Partie(j);
		
		//cr�ation et ajout de nouveau joueurs et d'une nouvelle liste
		Joueur c = new Joueur(Couleur.Noir, "Claude");
		Joueur d = new Joueur(Couleur.Blanc, "Daniel");
		List<Player> j2 = new ArrayList<Player>();
		j2.add(c);
		j2.add(d);
		
		//changement de liste de joueurs
		p.setJoueurs(j2);
		
		assertEquals(j2, p.getJoueurs());
	}
	
	@Test
	public void testChangePlayerInPlay() {
		//initialisation partie
		Joueur b = new Joueur(Couleur.Noir, "Bob");
		Joueur a = new Joueur(Couleur.Blanc, "Arthur");
		List<Player> j = new ArrayList<Player>();
		j.add(a);
		j.add(b);
		Partie p = new Partie(j);
		
		//verification du premier joueur ayant la main
		assertEquals(b, p.getInplay());
		
		p.changePlayerInPlay();
		
		//verification que le joueur ayant la main a chang�
		assertNotEquals(b, p.getInplay());
		assertEquals(a, p.getInplay());
	}
	
	@Test
	public void testPlateauFull() {
		//initialisation partie
				Joueur b = new Joueur(Couleur.Noir, "Bob");
				Joueur a = new Joueur(Couleur.Blanc, "Arthur");
				List<Player> j = new ArrayList<Player>();
				j.add(a);
				j.add(b);
				Partie p = new Partie(j);
				
				
				
		for(int i = 0; i < 8; i++) {
			for(int k = 0; k < 8; k++) {
				if((i == 3 && k == 4) || (i == 4 && k == 3) || (i == 3 && k == 3) || (i == 4 && k == 4)){
					//ne rien faire
				}else{
					p.getPlateP().setPionCase(p.getPlateP().getPlate()[i][k], Couleur.Noir);
				}
			}
		}
		assertTrue(p.isFull());
		
	}
}
