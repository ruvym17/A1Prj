package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Base extends Fixed {
	    //Track the total number of bases created
		private static int instanceCounter = 0;
		//The drone number that a specific base object will have
		private int sequenceNumber;
		
	Base(float x , float y) {
		super( x , y , 60 , ColorUtil.MAGENTA );
		// increment the total number of bases
		instanceCounter += 1;
		// assign this base instance a sequence number
		sequenceNumber = instanceCounter;
		setColor(ColorUtil.YELLOW);
		setSize(20);
	}
	
	//returns this base class instants sequence number
	public int getSequenceNumber(){
		return sequenceNumber ;
	}
	
	//returns total number of bases
	public int getNumOfBases(){
		return instanceCounter;
	}
	
	@Override
	//can't change size once created
	public void setSize(int size) {}
	
	@Override
	//can't change color once created
	public void setColor(int objColor) {}
	
	@Override
	//adding sequence number to parent toString	
	public String toString() {
		
		String info = "";
		
		//call super toString to get location size and type
		info+= super.toString();
		
		// heading
		info += " seqNum=" + this.getSequenceNumber() + " ";
		
		return info;
	}
}
