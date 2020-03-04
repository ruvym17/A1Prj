package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Drone extends Movable {
	//Track the total number of drones created
	private static int instanceCounter = 0;
	//The drone number that a specific drone object will have
	private int sequenceNumber;
	
	//constructor for a drone object with a random speed, size, heading, and black color
	Drone() {
		super( 0, ColorUtil.GRAY );
		
		randomSpeed();
		randomSize();
		
		//increment the total number of drones
		instanceCounter+=1;
		//assign this drone instance a number
		sequenceNumber=instanceCounter;
	}
	
	
	//drone move method that alters heading and then moves
	public void move() {
		// for some reason this won't work on my computer:
		//int headingModify = new Random().nextBoolean() ? (5) : (-5);
		
		//picks either 5 or -5
		int headingModify = (new Random().nextInt(2) == 0) ? (5) : (-5);
		
		//modify the heading and move the drone
		setHeading(headingModify + getHeading());
		super.move();
	}
	
	public int getsequenceNumber(){
		return sequenceNumber;
	}
	@Override
	//drones are not allowed to change color once they are created
	public void setColor(int objColor) {}
	
	public String toString() {
		String myString= super.toString();
		return myString;
	}
}
