/*
 * This will manage the command sequences 
 * 
 * When the user records a command sequence with the GUI, this module will
 * translate that into a CommandSequence object, and will also be in charge
 * of interfacing with the saved (.txt?) version of the CommandSequence object
 * 
 */

public class CommandSequenceManager {

	CommandSequence myCommandSequence = new CommandSequence();
	
	public CommandSequenceManager(){
		
	}
	
	/*
	 * Add the given packet to the command sequence log
	 */
	public boolean log(DataPacket packet){
		/*
		 * Not implemented in initial evolutionary prototype 
		 */
		
		
		return true;
	}
	
	
	/*
	 * Save the current session to disk
	 */
	public boolean save(){
		
		return true;
	}
}
