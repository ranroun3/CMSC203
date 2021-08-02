import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestSTUDENT {
	private double [][] dataset1STUDENT = {{1, 2, 3, 4, 5, 6},
									{1, -2, -3, -4, -5}, 
									{0.1, 0.2, 0.3, 0.4}, 
									{-1.2, 0, 2.8}, 
									{3, 5, 0.1, 2 },
									{4}};
	private double[][] dataset2STUDENT = {{5, 2, 3.1, 3, 5, 2.9}, 
									{1}, 
									{-2, -3}, 
									{8, 9, 10, 11, 12},
									{1, 1.5, 2, 2.5}}; 
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataset1STUDENT,5000,1000,2000);
			assertEquals(24000.0,result[0],.001);
			assertEquals(2000,result[1],.001);
			assertEquals(8000.0,result[2],.001);
			assertEquals(2000.0,result[3],.001);
			assertEquals(11000.0,result[4],.001);
			assertEquals(5000.0,result[5],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataset2STUDENT,5000,1000,2000);
			assertEquals(14000.0,result[0],.001);
			assertEquals(2000,result[1],.001);
			assertEquals(0.0,result[2],.001);
			assertEquals(25000.0,result[3],.001);
			assertEquals(6000.0,result[4],.001);
			
			
		}
		catch (Exception e) {
			fail("This should not have caused an Exception");
		} 
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		try{
			double result1 = HolidayBonus.calculateTotalHolidayBonus(dataset1STUDENT,5000,1000,2000);
			double result2 = HolidayBonus.calculateTotalHolidayBonus(dataset2STUDENT,5000,1000,2000);
			
			assertEquals(52000, result1, 0.001);
			assertEquals(47000, result2, 0.001);
		}
		catch (Exception e) {
			fail("This should not have caused an exception");
		}

}
}
