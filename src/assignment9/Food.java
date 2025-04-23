package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		x = Math.random() * (1 - FOOD_SIZE); // to account for food size so it doesnt go off the screen
		y = Math.random() * (1 - FOOD_SIZE);
	}
	
	/**
	 * @return random x value
	 */
	public double getX() {
		return x; 
	}
	
	/**
	 * @return random y value
	 */
	public double getY() {
		return y; 
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE / 2); // food size divided by 2 bc last parameter is radius & food size is diameter
	}
	
}
