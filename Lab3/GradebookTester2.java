import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester2 {
	private GradeBook g1, g2;
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(1);
		g1.addScore(2);
		g1.addScore(3);
		g1.addScore(4);
		g1.addScore(5);
		
		g2.addScore(4);
		g2.addScore(5);
		g2.addScore(6);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1=null;
		g2=null;
	}

	@Test
	void testAddScore() {
		
		assertTrue(g1.toString().equals("null1.0 2.0 3.0 4.0 5.0 "));
		assertTrue(g2.toString().equals("null4.0 5.0 6.0 0.0 0.0 "));
		
		assertEquals(5, g1.getScoreSize(), 0.01);
		assertEquals(3, g2.getScoreSize(), 0.01);	
	}

	@Test
	void testSum() {
		assertEquals(15, g1.sum(), 0.001);
		assertEquals(15, g2.sum(), 0.001);
	}

	@Test
	void testMinimum() {
		assertEquals(1, g1.minimum(), 0.001);
		assertEquals(4, g2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(14, g1.finalScore(), 0.001);
		assertEquals(11, g2.finalScore(), 0.001);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(5, g1.getScoreSize(), 0.01);
		assertEquals(3, g2.getScoreSize(), 0.01);
	}

	@Test
	void testToString() {	
		assertTrue(g1.toString().equals("null1.0 2.0 3.0 4.0 5.0 "));
		assertTrue(g2.toString().equals("null4.0 5.0 6.0 0.0 0.0 "));
	}

}
