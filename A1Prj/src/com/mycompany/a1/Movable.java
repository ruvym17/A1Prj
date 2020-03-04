package com.mycompany.a1;

import java.util.Random;
import java.lang.Math;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
//import com.codename1.charts.util.ColorUtil;

public abstract class Movable extends GameObject {
	
	private int heading;
	private int speed;
	
	Movable(int size, int objColor){
		super(size, objColor);
		randomHeading();
	}
	
	Movable(float x, float y, int heading, int speed, int size,  int objColor ){
		super(x , y, size , objColor);
		setSpeed(speed);
		setHeading(heading);
	}
	
	public void move() {
		
		int theta = 90- heading;
		float deltaX = (float) (Math.cos(Math.toRadians(theta))*speed);
		float deltaY = (float) (Math.sin(Math.toRadians(theta))*speed);
		
		Point oldLocation= getLocation();
		setLocation(oldLocation.getX()+deltaX,oldLocation.getY()+deltaY);
	}
	
	public void setHeading(int heading) {
		this.heading=heading;
	}
	
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	public int getHeading() {
		return heading;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void randomHeading() {
		Random random = new Random();
		heading = random.nextInt(360);
	}
	
	public void randomSpeed() {
		Random random = new Random();
		speed = 5+ random.nextInt(11);
	}
	
	@Override
	public void setSize(int size) {
		super.setSize(size);
	}
	
	@Override
	public int getSize() {
		return super.getSize();
	}

	
	@Override
	public float randomX() {
		return super.randomX();
	}
	
	@Override
	public float randomY() {
		return super.randomY();
	}
	
	@Override
	//make sure every class has a toString	
	public String toString() {
		
		String info = "";
		
		//call super toString to get location size and type
		info+= super.toString();
		
		// heading
		info += " heading=" + this.getHeading() + " ";
		
		// speed
		info += "speed=" + this.getSpeed() + " ";
		
		return info;
	}
	


}
