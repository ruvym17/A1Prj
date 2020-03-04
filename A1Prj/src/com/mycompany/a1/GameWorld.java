package com.mycompany.a1;

import java.util.Iterator;
import java.util.Vector;

import com.codename1.charts.util.ColorUtil;

public class GameWorld {
	
	private Vector<GameObject> collection= new Vector<GameObject>();
	
	private int clock;
	private int lives;
	private Cyborg playerCyborg;
	
	public void init() {
		
		// initial starting game variables
		clock= 0;
		lives=3;
		
		GameObject base1 = new Base(150,150);
		GameObject base2 = new Base(150,800);
		GameObject base3 = new Base(800,150);
		GameObject base4 = new Base(800,800);
		

		System.out.println("gameworld");
		System.out.println(base1.size);
		System.out.println(base1.color);
		
		collection.add(base1);
		collection.add(base2);
		collection.add(base3);
		collection.add(base4);
		
		playerCyborg = new Cyborg(150,150);
		
		collection.add(playerCyborg);
		
		Drone drone1 = new Drone();
		Drone drone2 = new Drone();
		
		collection.add(drone1);
		collection.add(drone2);
		
		EnergyStation station1= new EnergyStation();
		EnergyStation station2= new EnergyStation();

		
		collection.add(station1);
		collection.add(station2);
		
	}
	
	
	//print a text based map of the world
	public void printMap() {
		
		Iterator<GameObject> iterator = collection.iterator();
		
		//check if there are any GameObject children
		while(iterator.hasNext()) {
			//print out each object toString
			System.out.println(iterator.next().toString());
		}
		
	}
	
	public void turnLeft() {
		playerCyborg.steerLeft();
	}
	
	public void turnRight() {
		playerCyborg.steerRight();
	}
	
	public void accelerate() {
		playerCyborg.accelerate();
	}
	
	public void brake() {
		playerCyborg.brake();
	}
	
	//cyborg reaches base simulation
	public void collisionBase(int baseNumber) {
		if(baseNumber == ( playerCyborg.getLastBaseReached() + 1 )) {
			
			playerCyborg.setLastBaseReached(baseNumber);
			
		}
	}
	
	//player cyborg collides with a drone, cyborg suffers 10 damage
	public void collisionDrone() {
		playerCyborg.addDamage(10);;
	}
	
	//player cyborg reaches an energy station and the station size gets added to cyborg health
	public void collisionEnergyStation(int stationSize) {
		playerCyborg.addEnergy(stationSize);
	}
	
	public void collisionCyborg() {
		
	}
	
	public void advanceClock() {
		clock++;
		for (int i = 0; i < collection.size(); i++) {
			if (collection.elementAt(i) instanceof Movable) {
				Movable mObj = (Movable) collection.elementAt(i);
				mObj.move();
			}
		}
	}

	public String getGameState(){
		
		String state;
		
		//current lives left
		state = "Lives left: "+ String.valueOf(lives) + "\n";
		//current clock time
		state += "Current clock time: "				+String.valueOf(clock) + "\n";
		// max base reached
		state += "Maximum base reached: " 			+String.valueOf(playerCyborg.getLastBaseReached()) + "\n";
		//current player fuel
		state += "Current player fuel: "			+String.valueOf( playerCyborg.getEnergyLevel() ) + "\n";
		// add current player damage
		state += "Current player damage level: "	+String.valueOf( playerCyborg.getDamageLevel()) + "\n";
		// maximum damage of cyborg
		state += "Player Max Damage: "				+String.valueOf( playerCyborg.getMaxDamage() ) + "\n";
		
		// return string
		return state;
		
	}
	
	public void test() {
		System.out.println("/n test /n size:  "+ playerCyborg.getSize() + "/n color"+ playerCyborg.getColor());
	}

}
