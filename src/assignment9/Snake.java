package assignment9;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		this.segments = new LinkedList<BodySegment>(); 
		BodySegment one = new BodySegment(deltaX, deltaY, SEGMENT_SIZE / 2);
		segments.add(one);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		// have every segment behind the head follow the segment in front of it (eventually the segment behind the head follows the head)
		for(int i = segments.size()-1; i > 0; i--) {	
			BodySegment inFront = segments.get(i-1);
			segments.get(i).setX(inFront.getX());
			segments.get(i).setY(inFront.getY());
		}
		
		// moves the head
		BodySegment head = segments.getFirst();
		head.setX(deltaX + head.getX());
		head.setY(deltaY + head.getY());
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(StdDraw.GREEN);
		for(int i = 0; i < segments.size(); i++) { // or a while loop while segments != null
			StdDraw.filledCircle(segments.get(i).getX(), segments.get(i).getY(), SEGMENT_SIZE / 2);
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		BodySegment head = segments.getFirst();
		double distanceX = head.getX() - f.getX(); 
		double distanceY = head.getY() - f.getY(); 
		double distance = Math.sqrt((Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
		if (distance < SEGMENT_SIZE) {
			BodySegment newTail = segments.getLast();
			segments.addLast(new BodySegment(newTail.getX(), newTail.getY(), SEGMENT_SIZE / 2));
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.getFirst();
		double x = head.getX(); 
		double y = head.getY();
		boolean inBounds = x<=1 && x>=0 && y>=0 && y<=1; 
		return inBounds;
	}
}
