
/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class determines the bonus amounts for the various stores (rows) 
 * in a particular category(column)
 */
public class HolidayBonus {
	/**
	 * Constructor
	 */
	public HolidayBonus() {

	}
	
	/**
	 * Calculates the holiday bonus for each store
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(
			double[][] data, double high, 
			double low, double other) {

		double[] bonusAmts= new double[data.length];
		for (int row= 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				double highestSalesInCategory = TwoDimRaggedArrayUtility.getHighestInColumn(data,col);
				double lowestSalesInCategory= TwoDimRaggedArrayUtility.getLowestInColumn(data,col);
				
				if(data[row][col] >0) {
					if(data[row][col] == highestSalesInCategory)
						bonusAmts[row]= bonusAmts[row]+ high;
					else if(data[row][col] == lowestSalesInCategory)
						bonusAmts[row]= bonusAmts[row]+ low;
					else {
						bonusAmts[row]= bonusAmts[row]+ other;
					}
				}
			}
		}
		return bonusAmts;
	}

	/**
	 * Calculates the total holiday bonuses
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return the total bonus amount
	 */
	public static double calculateTotalHolidayBonus(
			double[][] data, double high,
			double low, double other) {
		double[]bonuses= calculateHolidayBonus(data, high, low, other);
		double total = 0;
		for(double d: bonuses) {
			total+=d;
		}
		return total;
	}
}
