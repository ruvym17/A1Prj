package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.Random;

public abstract class GameObject {
	
	
	@SuppressWarnings("deprecation")
	private final String type = this.getClass().getSimpleName().toString();
	private Point location;
	public int color= ColorUtil.GRAY;
	public int size;
	
	//Constructor - maybe set up the random location here
	GameObject(int size, int objColor) {
		super();
		this.randomLocation();
		this.setSize(size);
		this.setColor(objColor);
	}
	
	GameObject(float x, float y, int size, int objColor ){
		this.setSize(size);
		this.setColor(objColor);
		this.setLocation(x,y);
		System.out.println("gameobject");
		System.out.println(this.size);
		System.out.println(this.color);
			
	}
	
	
	//Setters for location, color and size
	public void setLocation(float x,float y){
		location = new Point(x,y);
	}

	
	public void setColor(int objColor) {
		color = objColor;
		System.out.println("afterset color");
		System.out.println(objColor);
	}
	
	
	public void setSize(int newSize) {
		size=newSize;
		System.out.println("after setSize");
		System.out.println(newSize);

	}
	
	//Getters for size location and color
	public Point getLocation() {
		return location;
	}

	public int getSize() {
		return size;
	}
	
	public int getColor() {
		return color;
	}
	
	public String getType() {
		return this.type;
	}
	
	//Helper methods for random values and location
	public void randomSize() {
		Random random = new Random();
		setSize(10+ random.nextInt(41));
	}
	
	public void randomLocation() {
		Random random = new Random();
		
		float locX= random.nextInt(1000)+random.nextFloat();
		float locY= random.nextInt(1000)+random.nextFloat();
		
		location = new Point(locX,locY);
	}
	
	public float randomX() {
		Random random = new Random();
		float locX= random.nextInt(1000)+random.nextFloat();
		return locX;
	}
	
	public float randomY() {
		Random random = new Random();
		float locX= random.nextInt(1000)+random.nextFloat();
		return locX;
	}
	
	@Override
	//make sure every class has a toString	
	public String toString() {
		//float x = Math.round(location.getX());
		//float y = Math.round(location.getY());
		
		String info = "";
		
		// type
		info += "\n" + this.getType() + ": ";
		// location
		info += "loc=" +  this.getLocation().getX() + "," + this.getLocation().getY() + " ";
		
		// color
		info += "color=[" + ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor()) + "," + ColorUtil.blue(getColor()) + "] ";
		
		// size
		info += "size=" + this.getSize();
		
		return info;
	}
	
}
