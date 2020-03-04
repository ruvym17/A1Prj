package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;


public class EnergyStation extends Fixed {
	private boolean visited= false;
	
	EnergyStation(){
		super (0, ColorUtil.BLUE );
		randomSize();
		
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void visitEnergyStation() {
		visited= true;
	}
	
	public String toString() {
		String parentDesc = super.toString();
		
		parentDesc += " capacity=" + getSize() + " ";
		
		return parentDesc;
	}

}
