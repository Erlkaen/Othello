package Game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PionTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetColor() {
		Pion p1 = new Pion(Couleur.Noir);
		assertNotNull(p1.getColor());
		assertTrue(p1.getColor()==Couleur.Noir);
		assertTrue(p1.getColor().getClass()==Couleur.class);

		
		Pion p2 = new Pion(Couleur.Blanc);
		assertNotNull(p2.getColor());
		assertTrue(p2.getColor()==Couleur.Blanc);
		assertTrue(p2.getColor().getClass()==Couleur.class);
	}
	
	@Test
	public void testSetColor() {
		Pion p1 = new Pion(Couleur.Noir);
		p1.setColor(Couleur.Noir);
		assertNotNull(p1.getColor());
		assertTrue(p1.getColor()==Couleur.Noir);
		assertTrue(p1.getColor().getClass()==Couleur.class);

		Pion p2 = new Pion(Couleur.Blanc);
		p2.setColor(Couleur.Blanc);
		assertNotNull(p2.getColor());
		assertTrue(p2.getColor()==Couleur.Blanc);
		assertTrue(p2.getColor().getClass()==Couleur.class);
	}
	
	@Test
	public void testChangeColor() {
		Pion p1 = new Pion(Couleur.Noir);
		assertTrue(p1.changeColor()==Couleur.Blanc);
		assertNotNull(p1.getColor());
		assertTrue(p1.getColor().getClass()==Couleur.class);
		
		Pion p2 = new Pion(Couleur.Blanc);
		assertTrue(p2.changeColor()==Couleur.Noir);
		assertNotNull(p2.getColor());
		assertTrue(p2.getColor().getClass()==Couleur.class);
	}
	
	

}
