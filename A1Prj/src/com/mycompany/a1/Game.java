package com.mycompany.a1;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Form;

public class Game extends Form {
	
	private boolean exit;
	private GameWorld gw;

	public Game() {
		exit=false;
		gw = new GameWorld();
		gw.init();
		play();
	}

	private void play() {
		
		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt)
			{
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				
				//check 1-9 options
				if(sCommand.length() != 0) {
					//check if command is an integer
					if(isInteger(sCommand)) {
						//convert command to int
						int command =Integer.parseInt(sCommand);
						//make sure command is 1-9
						if( 0 < command && command < 10) {
							//call specific base collision
							//collisionCyborgBase();
							//empty out command so it skips the switch cases
							sCommand= "";
						}
					}
				}//end check 1-9
				
				if(sCommand.length() != 0)
					switch (sCommand.charAt(0)) 
					{
					case 'x':
						exit();
						break;
						
					//add code to handle rest of the commands
					case 'y':
						// user confirmed exit by saying yes, if option 'x'not selected then prompt user to select exit
						if(exit)
							System.exit(0);
						else
							System.out.println("Please select exit first");
						break;
						
					case 'n':
						// user denied exit by saying no
						System.out.println("Game will not exit");
						exit=false;
						
						break;
						
					case 'm':
						// tell the game world to output a 'map'
						gw.printMap();
						break;
						
					case 'd':
						//current game/player-cyborg
						System.out.println("Game State: \n" + gw.getGameState());
						break;
						
					case 't':
						//tell the game world that the game clock has ticked
						gw.advanceClock();
						System.out.println("Time advanced");
						break;
						
					case 'g':
						//drone/cyborg collision
						//fade color of cyborg and increase damage
						//if necessary reduce speed limit
						gw.collisionDrone();
						System.out.println("Drone Collision");

						break;
					case 'e':
						//cyborg/energyStation collision 
						//tell the game world that this collision has occurred
						gw.collisionEnergyStation(15);
						System.out.println("EnergyStation Collision");

						break;
						
					case 'c':
						//player cyborg/opponent cyborg collision
						gw.collisionCyborg();
						System.out.println("Cyborg Collision");

						break;
						
					case 'r':
						//turn cyborg right
						gw.turnRight();
						System.out.println("Turn right");

						break;
						
					case 'l':
						//turn cyborg left
						gw.turnLeft();
						System.out.println("Turn left");

						break;
						
					case 'b':
						//tell the game world to brake (immediately reduce the speed of) the player cyborg
						gw.brake();
						System.out.println("Brakes applied");
						break;
						
					case 'a':
						//tell the game world to accelerate (immediately increase the speed of) the player cyborg
						gw.accelerate();
						System.out.println("Accelerating");
						break;
					case 'q':
						//test case
						System.out.println("Test case");
						gw.test();
						
						break;
					} //switch
			} //actionPerformed
		}
		); //new ActionListener()
	}//play
	
	public void exit() {
		
		System.out.println("Are you sure that you want to quit?");
		exit=true;
		
	}
	
	//helper method for figuring out if input is a number
	public static boolean isInteger(String s) {
	      boolean isValidInteger = false;
	      try
	      {
	         Integer.parseInt(s);
	 
	         // s is a valid integer
	 
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         // s is not an integer
	      }
	 
	      return isValidInteger;
	   }
	
	
}//Game
