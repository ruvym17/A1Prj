package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import java.util.Random;

public class Cyborg extends Movable implements ISteerable {
	
	//how fast the cyborg can move
	private int maxSpeed;
	//how much energy the cyborg has
	private int energyLevel;
	//how much energy the cyborg uses every clock tick
	private int energyConsumptionRate;
	//the last base the cyborg reached
	private int lastBaseReached;
	//maximum steering direction and the steering direction
	private int steeringDirection;
	private int max_steer=40;
	//deacceleration rate
	private int dec_rate;
	//acceleration rate
	private int acc_rate;
	//maximum damage the cyborg can take and its health
	private int maxDamage;
	private int damageLevel;
	
	public Cyborg(float x, float y) {
		super(x ,y ,0 ,0 , 99 , ColorUtil.GRAY);
		
		lastBaseReached=1;
		energyConsumptionRate=2;
		
		steeringDirection=0;
		maxSpeed=100;
		
		maxDamage=100;
		damageLevel=0;
		energyLevel=100;
		
		dec_rate= 3;
		acc_rate= 3;
		//randomSize();
		}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public int getLastBaseReached() {
		return lastBaseReached;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public int getSteeringDirection() {
		return steeringDirection;
	}
	
	public int getDamageLevel() {
		return damageLevel;
	}
	
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public void setLastBaseReached(int nextBase) {
		lastBaseReached = nextBase;
	}
	
	public void Move(){
		if ((damageLevel<maxDamage) && (energyLevel>0) && (getSpeed() > 0))
			setHeading( getHeading() + steeringDirection );
		useEnergy();
		super.move();
		
		
	}
	
	public void accelerate() {
		  if((getSpeed() < maxSpeed*((maxDamage-damageLevel)/maxDamage)) && (energyLevel >0)) {
			  setSpeed(getSpeed()+acc_rate);
			  if(getSpeed() > maxSpeed) {
				  setSpeed(maxSpeed);
			  }
		  }
	}
	
	public void brake() {
		if(getSpeed()>0) {
			setSpeed(getSpeed()-dec_rate);
			if (getSpeed() < 0) {
				setSpeed(0);
			}
		}
	}
	
	public void addDamage(int damage) {
		damageLevel -= damage;
	}
	
	public void adjustSpeed() {
		
	}
	
	//cyborg gets health equivalent to the energy station size
	public void addEnergy(int size) {
		energyLevel += size;
	}
	
	public void useEnergy() {
		energyLevel-= energyConsumptionRate;
	}
	/*
	@Override
	// can't change size once created
	public void setSize(int size) {}
	
	@Override
	// can't change color once created
	public void setColor(int objColor) {
	}
*/
	@Override
	public void steerLeft() {
		if(steeringDirection > -(max_steer)) {
			steeringDirection += 5;
		}
		else {
			System.out.println("Steering too far left");
		}
	}
	
	@Override
	public void steerRight() {
		if(steeringDirection < max_steer) {
			steeringDirection -= 5;
		}
	}

	public String toString() {

		String parentDesc = super.toString();
		
		parentDesc += "maxSpeed=" + this.getSpeed() + " ";
		parentDesc += "steeringDirection=" + this.getSteeringDirection() + " ";
		parentDesc += "energyLevel=" + this.getEnergyLevel() + " ";
		
		return parentDesc;
	}
		
	public int rand() {
		Random random = new Random();
		if(random.nextInt(2)==0) {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	
}
