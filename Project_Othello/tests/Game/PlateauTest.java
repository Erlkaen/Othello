package Game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("----------------------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("----------------------------");
	}

	@Test
	public void testConstructor() {
		Plateau p = new Plateau();
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i == 3 && j == 4) || (i == 4 && j == 3)){
					assertTrue(p.getPlate()[i][j].getPion().getColor()==Couleur.Noir);
				}
				else if((i == 3 && j == 3) || (i == 4 && j == 4)){
					assertTrue(p.getPlate()[i][j].getPion().getColor()==Couleur.Blanc);
				}
				else {
					assertTrue(p.getPlate()[i][j].isFree());
					assertEquals(p.getPlate()[i][j].getPion(), null);
				}
			}
		}
	}
	
	@Test
	public void testGetEtSetPlate() {
		Plateau p = new Plateau();
		
		//creation d'un nouveau plateau
		Case[][] pl = new Case[8][8];
		
		//affectation de ce plateau
		p.setPlate(pl);
		
		assertSame(pl, p.getPlate());
	}
	
	@Test
	public void testSetPionCase() {
		Plateau p = new Plateau();
		
		//verification case vide
		assertTrue(p.getPlate()[1][1].isFree());
		
		//affectation de la case au plateau
		p.setPionCase(p.getPlate()[1][1], Couleur.Noir);
		
		assertFalse(p.getPlate()[1][1].isFree());
		assertEquals(p.getPlate()[1][1].getPion().getColor(), Couleur.Noir);
	}
	
	@Test
	public void testIsCaseFree() {
		Plateau p = new Plateau();
		
		assertTrue(p.isCaseFree(1, 1));
		assertFalse(p.isCaseFree(4, 4));
	}
	
	@Test
	public void testIsAdjFree() {
		Plateau p = new Plateau();
		
		//test aucun pion adj
		assertTrue(p.isAdjFree(p.getPlate()[1][1]));
		
		//test pion diagonale
		assertFalse(p.isAdjFree(p.getPlate()[2][2]));
		//test pion case adj
		assertFalse(p.isAdjFree(p.getPlate()[2][3]));
	}
	
	@Test
	public void testIsPlayable() {
		Plateau p = new Plateau();

		assertTrue(p.isPlayable(p.getPlate()[2][3], Couleur.Noir));
		assertFalse(p.isPlayable(p.getPlate()[2][3], Couleur.Blanc));
		assertFalse(p.isPlayable(p.getPlate()[1][1], Couleur.Noir));
		assertFalse(p.isPlayable(p.getPlate()[3][3], Couleur.Noir));
	}
	
	@Test
	public void testHowManyWhite() {
		Plateau p = new Plateau();
		
		assertEquals(p.howManyWhite(), 2);
		
		p.setPionCase(p.getPlate()[2][2], Couleur.Blanc);
		assertEquals(p.howManyWhite(), 3);
	}
	
	@Test
	public void testHowManyBlack() {
		Plateau p = new Plateau();
		
		assertEquals(p.howManyBlack(), 2);
		
		p.setPionCase(p.getPlate()[2][2], Couleur.Noir);
		assertEquals(p.howManyBlack(), 3);
	}
}
