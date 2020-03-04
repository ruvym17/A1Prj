package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

public abstract class Fixed extends GameObject {
	
	Fixed(int size, int objColor){
		super( size , objColor );
	}
		
	Fixed(float x, float y, int size, int objColor){
		super(x , y, size , objColor );
		System.out.println("fixed");
		System.out.println(size);
		System.out.println(objColor);
	}
	
	public String toString() {
		return super.toString();
	}

}
