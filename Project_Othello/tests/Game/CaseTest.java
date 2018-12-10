package Game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaseTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("----------------------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("----------------------------");
	}

	
/*--------------------------------------------------------------------------------------
tests sur les méthodes
--------------------------------------------------------------------------------------*/	
	
	@Test
	public void testIsFree() {
		Case c1 = new Case(1, 4);
		assertTrue(c1.isFree());
		assertNotNull(c1.isFree());
		
		Case c2 = new Case(1, 4, new Pion(Couleur.Noir));
		assertFalse(c2.isFree());
		assertNotNull(c2.isFree());
	}
	
	@Test
	public void testGetPion() {
		Case c1 = new Case(1, 4);
		assertEquals(c1.getPion(), null);
	
		Pion p1 = new Pion(Couleur.Noir);
		Case c2 = new Case(1, 4, p1);
		assertEquals(c2.getPion(),p1);
		
		Pion p2 = new Pion(Couleur.Blanc);
		Case c3 = new Case(1, 4, p2);
		assertEquals(c3.getPion(), p2);
	}
	
	@Test
	public void testGetX() {
		Case c1 = new Case(1, 4);
		assertEquals(c1.getX(), 1);
		
		Case c2 = new Case(1, 4, new Pion(Couleur.Noir));
		assertEquals(c2.getX(), 1);
	}
	
	@Test
	public void testGetY() {
		Case c1 = new Case(1, 4);
		assertEquals(c1.getY(), 4);
		
		Case c2 = new Case(1, 4, new Pion(Couleur.Noir));
		assertEquals(c2.getY(), 4);
	}
	
	@Test
	public void testSetFree() {
		Case c1 = new Case(1, 4);
		c1.setFree(true);
		assertTrue(c1.isFree());
		
		Case c2 = new Case(1, 4);
		c2.setFree(false);
		assertFalse(c2.isFree());
		
		Case c3 = new Case(1, 4, new Pion(Couleur.Noir));
		c3.setFree(true);
		assertTrue(c3.isFree());
		
		Case c4 = new Case(1, 4, new Pion(Couleur.Noir));
		c4.setFree(false);
		assertFalse(c4.isFree());
	}
	
	@Test
	public void testSetPion() {
		Pion p1 = new Pion(Couleur.Noir);
		Case c1 = new Case(1, 4);
		c1.setP(p1);
		assertEquals(c1.getPion(), p1);

		Pion p2 = new Pion(Couleur.Blanc);
		Case c2 = new Case(1, 4, new Pion(Couleur.Noir));
		c2.setP(p2);
		assertEquals(c2.getPion(), p2);
		
		Pion p3 = new Pion(Couleur.Noir);
		Case c3 = new Case(1, 4, new Pion(Couleur.Noir));
		c3.setP(p3);
		assertEquals(c3.getPion(), p3);
	}
	
	@Test
	public void testSetX() {
		Case c1 = new Case(1, 4);
		c1.setX(5);
		assertEquals(c1.getX(), 5);
		
		Case c2 = new Case(1, 4, new Pion(Couleur.Noir));
		c2.setX(6);
		assertEquals(c2.getX(), 6);
	}
	
	@Test
	public void testSetY() {
		Case c1 = new Case(1, 4);
		c1.setY(5);
		assertEquals(c1.getY(), 5);
		
		Case c2 = new Case(1, 4, new Pion(Couleur.Noir));
		c2.setY(6);
		assertEquals(c2.getY(), 6);
	}
	
	@Test
	public void testChangeFree() {
		Case c1 = new Case(1, 4);
		assertFalse(c1.changeFree());
		
		Case c2 = new Case(1, 4, new Pion(Couleur.Noir)); 
		assertTrue(c2.changeFree());
	}
	
/*--------------------------------------------------------------------------------------
tests  sur les constructeurs
--------------------------------------------------------------------------------------*/	

	
	@Test
	public void ConstructorSansPion() {
		int x = 1;
		int y = 4;
		Case c1 = new Case(x, y);
		assertNotNull(c1);
		assertNull(c1.getPion());
		assertEquals(c1.getX(), x);
		assertEquals(c1.getY(), y);
		
		x = -1;
		c1 = new Case(x, y);
		assertNotEquals(c1.getX(), x);
		
		x = 1;
		y = -4;
		c1 = new Case(x, y);
		assertNotEquals(c1.getY(), y);
		
		x = 12;
		y = 5;
		c1 = new Case(x, y);
		assertNotEquals(c1.getY(), x);
		
		x = 5;
		y = 15;
		c1 = new Case(x, y);
		assertNotEquals(c1.getY(), y);
	}
	
	@Test
	public void ConstructorAvecPion() {
		int x = 1;
		int y = 4;
		Pion p = new Pion(Couleur.Noir);
		Case c1 = new Case(x, y, p);
		assertNotNull(c1);
		assertNotNull(c1.getPion());
		assertEquals(Couleur.Noir, c1.getPion().getColor());
		assertEquals(c1.getX(), x);
		assertEquals(c1.getY(), y);
		
		x = -1;
		c1 = new Case(x, y);
		assertNotEquals(c1.getX(), x);
		
		x = 1;
		y = -4;
		c1 = new Case(x, y);
		assertNotEquals(c1.getY(), y);
		
		x = 12;
		y = 5;
		c1 = new Case(x, y);
		assertNotEquals(c1.getY(), x);
		
		x = 5;
		y = 15;
		c1 = new Case(x, y);
		assertNotEquals(c1.getY(), y);
	}
}
