import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * This will manage the command sequences 
 * 
 * When the user records a command sequence with the GUI, this module will
 * translate that into a CommandSequence object, and will also be in charge
 * of interfacing with the saved (.txt?) version of the CommandSequence object
 * 
 */

public class CommandSequenceManager {

	CommandSequence commandSequence = new CommandSequence();
	
	public CommandSequenceManager(){
		
	}
	
	
	
	/*
	 * Add the given packet to the command sequence log
	 */
	public boolean log(DataPacket packet){
		return commandSequence.addCommandToSequence(packet);
	}
	
	
	/*
	 * Save the current session to disk
	 */
	@SuppressWarnings("resource")
	public boolean saveSequenceToFile(String filepath){
		
		FileOutputStream outputStream;
		
		
		// Open the file output stream
		try {
			outputStream = new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		
		// Write the entire command list to a file
		for(int i = 0; i < commandSequence.size(); i++){
			try {
				outputStream.write(commandSequence.getCommand(i).getAsByteArray());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		// Close the output stream
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	/*
	 * Load a saved command sequence from a file on disk
	 */
	public boolean loadSequenceFromFile(String filepath){
		return true;
	}
}
