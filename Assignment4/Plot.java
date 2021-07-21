/**
 * CMSC 203
 * Gregory Grinberg
 * Montgomery College
 * Assignment 4
 * 7/19/2021
 * @author ronys
 * Description: This class represents a plot object, and has methods to check if incoming plots overlap or encompass this plot
 * 
 *
 */
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;

	/**
	 * A no-arg constructor that creates a plot object with default values
	 */
	public Plot() {
		x=0;
		y=0;
		width=1;
		depth=1;
	}

	/**
	 * A copy constructor that creates a plot object from another plot object
	 * @param p the plot to be copied
	 */
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}

	/**
	 * A plot constructor that takes in parameters for the values of the plots
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param width width of plot
	 * @param depth depth of plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * Setter method for the upper left x coordinate of the plot
	 * @param x
	 */
	public void setX(int x) {
		this.x=x;
	}

	/**
	 * Getter method for the upper left x coordinate of the plot
	 * @return upper left x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter method for the upper left y coordinate of the plot
	 * @param y upper left y
	 */
	public void setY(int y) {
		this.y=y;
	}

	/**
	 * Getter method for the upper left y coordinate of the plot
	 * @return upper left y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter method for the plot width
	 * @param width sets width
	 */
	public void setWidth(int width) {
		this.width=width;
	}

	/**
	 * Getter method for plot width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Setter method for depth of plot
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth=depth;
	}

	/**
	 * Getter method for depth of plot
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * ToString method with plot info
	 * @return String with info
	 */
	public String toString() {
		return "Upper left: (" + this.getX() + "," + this.getY() + "); Width: " + this.getWidth() + " Depth: " + this.getDepth();
	}

	
	/**
	 * Method that checks whether the current plot overlaps a specified plot
	 * @param plot the plot to be checked with
	 * @return true if overlaps, false if no
	 */
	public boolean overlaps(Plot two) {
		
//		int rec1[][] = new int[4][2];
//		int rec2[][] = new int[4][2];
//		boolean overlaps=false;
//		//top left, top right, bottom right, bottom left
//		rec1[0][0] = this.getX();
//		rec1[0][1]= this.getY();
//		rec1[1][0]=this.getX()+this.getWidth();
//		rec1[1][1]=this.getY();
//		rec1[2][0] = this.getX()+this.getWidth();
//		rec1[2][1] = this.getY()+this.getDepth();
//		rec1[3][0]= this.getX();
//		rec1[3][1] = this.getY()-this.getDepth();
//		
//		rec2[0][0] = two.getX();
//		rec2[0][1]= two.getY();
//		rec2[1][0]=two.getX()+two.getWidth();
//		rec2[1][1]=two.getY();
//		rec2[2][0] = two.getX()+two.getWidth();
//		rec2[2][1] = two.getY()+two.getDepth();
//		rec2[3][0]= two.getX();
//		rec2[3][1] = two.getY()-two.getDepth();
//		
//		for(int i=0; i<rec1.length; i++) {
//				if(rec1[i][0]< rec2[1][0] && rec1[i][1] <rec2[1][1] &&
//						rec1[i][0]<rec2[3][0] && rec1[i][1] <rec2[3][1]) {
//					overlaps=true;
//				}
//			
//		}
//		for(int i=0; i<rec1.length; i++) {
//			if(rec2[i][0]< rec1[1][0] && rec2[i][1] <rec1[1][1] &&
//					rec2[i][0]<rec1[3][0] && rec2[i][1] <rec1[3][1]) {
//				overlaps=true;
//			}
//		
//	}
//		return overlaps;
	


				int topRightX=this.getX()+this.getWidth();
				int topRightY=this.getY();
				int bottomLeftX = this.getX();
				int bottomLeftY = this.getY()-this.getDepth();
				
				int twoTopRightX=two.getX()+two.getWidth();
				int twoTopRightY=two.getY();
				int twoBottomLeftX = two.getX();
				int twoBottomLeftY = two.getY()-two.getDepth();
				
	
				if (topRightY < twoBottomLeftY 
						|| bottomLeftY > twoTopRightY) {
					return false;
				}
				if (topRightX < twoBottomLeftX
						|| bottomLeftX > twoTopRightX) {
					return false;
				}
				return true;
				}



	/**
	 * Method that checks whether or not the current plot encompasses(envelops/surrounds) a specified plot
	 * @param plot the plot which will fit inside the current plot
	 * @return true if encompasses, false if not
	 */
	public boolean encompasses(Plot plot) {
		boolean encompasses=false;
		int topRightX=this.getX()+this.getWidth();
		int topRightY=this.getY();
		int bottomLeftX = this.getX();
		int bottomLeftY = this.getY()-this.getDepth();
		int twoTopRightX=plot.getX()+plot.getWidth();
		int twoTopRightY=plot.getY();
		int twoBottomLeftX = plot.getX();
		int twoBottomLeftY = plot.getY()-plot.getDepth();
		if(topRightY>=twoTopRightY && topRightX>=twoTopRightX 
				&& bottomLeftX<=twoBottomLeftX 
				&& bottomLeftY<=twoBottomLeftY) {
			encompasses=true;

			//	if (plot.getX() >= getX() && plot.getX() + plot.getWidth() >= getX() + getWidth()
			//	&& plot.getX() + plot.getDepth() >= getX() + getDepth()
			//	&& plot.getX() + plot.getDepth() + plot.getWidth() >= getX() + getDepth() + getWidth()
			//	&& plot.getX() + plot.getDepth() + plot.getWidth() + plot.getDepth() >= getX() + getDepth() + getWidth()
			//	+ getDepth()
			//	&& plot.getX() + plot.getDepth() >= getX() + getDepth()
			//	&& plot.getX() < getX() && plot.getX() + plot.getWidth() < getWidth() + getX() 
			//	&& plot.getY() < getX() && plot.getY() < getY() + getWidth()) {


		}
		return encompasses;
	}
}
