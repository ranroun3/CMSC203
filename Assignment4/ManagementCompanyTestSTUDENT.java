

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3, p4, p5, p6;
	ManagementCompany mgmtCo; 
	@Before
	public void setUp() throws Exception {
		mgmtCo = new ManagementCompany("testCompany1", "ID123", 1.25);
		
		p1= new Property("Penthouse Suite", "NYC", 10000, "Bob Jones", 6, 6, 1, 1);
		p2= new Property("Log Cabin", "Smoky Mountains", 500, "Kanye West", 2, 2, 1, 1);
		p3= new Property("Whitehouse", "Washington DC", 100, "Biden", 4, 4, 1, 1);	
		p4= new Property("Taco Truck", "Highway", 150, "Joseph", 8, 8, 1, 1);
		p5= new Property("Duplex", "Bethesda", 3200, "Rony Stephan", 7, 2, 1, 1);
		p6= new Property("Townhome" , "Rockville", 1900, "Montgomery College Staff");
		
		mgmtCo.addProperty(p1);
		mgmtCo.addProperty(p2);
		mgmtCo.addProperty(p3);
	}

	@After
	public void tearDown() {
		p1=p2=p3=null;
		mgmtCo=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		
		assertEquals(mgmtCo.addProperty(p4), 3, 0);
		assertEquals(mgmtCo.addProperty(p5), 4, 0);
		assertEquals(mgmtCo.addProperty(p6), -1, 0);
		
		//fail("STUDENT test not implemented yet");
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(mgmtCo.maxRentProp(), 10000.0, 0);
		
		//fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(mgmtCo.totalRent(), 10600.0, 0);
		//fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
	}

 }
