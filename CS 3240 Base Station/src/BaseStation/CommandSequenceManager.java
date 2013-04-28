package BaseStation;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/*
 * This will manage the command sequences 
 * 
 * When the user records a command sequence with the GUI, this module will
 * translate that into a CommandSequence object, and will also be in charge
 * of interfacing with the saved (.txt?) version of the CommandSequence object
 * 
 */

public class CommandSequenceManager {

	private BufferedWriter out;

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
	public boolean saveSequenceToFile(String filename){
		
		DataOutputStream outputStream;
		File file = new File("C:/deleteme/" + filename + ".dat");		
		
		// Open the file output stream
		try {			
			outputStream = new DataOutputStream(new FileOutputStream(file));
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
	//	
	//	return true;
		file = new File("C:/deleteme/" + filename + "Time.dat");
		
		try {			
			outputStream = new DataOutputStream(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			for (int i = 0; i < commandSequence.size(); i++) {
				outputStream.writeLong(commandSequence.getTime(i));
			}
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/*
	 * Load a saved command sequence from a file on disk
	 */
	public boolean loadSequenceFromFile(String filename) {
		commandSequence.clear();
		File file = new File("C:/deleteme/" + filename + ".dat");

		try {
	      InputStream is = new FileInputStream(file);
	      DataInputStream din = new DataInputStream(is);
	      while (is.available() > 6) { // at least 7 bytes left to read
	        byte[] input = new byte[7];
	        for (int i = 0; i < 7; i++) {
	        	input[i] = din.readByte();
	        }
	        commandSequence.addCommandToSequence(new DataPacket(input));
	      }
	      din.close();
	    } catch (IOException ioe) {
	      return false;
	    }
		
		file = new File("C:/deleteme/" + filename + "Time.dat");
		commandSequence.clearTime();
		
		try {
		      InputStream is = new FileInputStream(file);
		      DataInputStream din = new DataInputStream(is);
		      while (is.available() > 7) { // at least 8 bytes left to read
		        long input = din.readLong();
		        commandSequence.addTime(input);
		      }
		      din.close();
		    } catch (IOException ioe) {
		      return false;
		    }
		
	}
}
