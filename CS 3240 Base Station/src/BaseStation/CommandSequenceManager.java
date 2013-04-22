package BaseStation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This will manage the command sequences 
 * 
 * When the user records a command sequence with the GUI, this module will
 * translate that into a CommandSequence object, and will also be in charge
 * of interfacing with the saved (.txt?) version of the CommandSequence object
 * 
 */

public class CommandSequenceManager {
	
	private File file;
	BufferedWriter out;

	CommandSequence commandSequence = new CommandSequence();
	
	public CommandSequenceManager(){
		new File("C:/deleteme/").mkdir();
		file = new File("C:/deleteme/" + "log.txt");
		file.delete();
		file.createNewFile();
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
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
		
	//	FileOutputStream outputStream;
		
		
		// Open the file output stream
	//	try {
	//		outputStream = new FileOutputStream(filepath);
	//	} catch (FileNotFoundException e) {
	//		e.printStackTrace();
	//		return false;
	//	}
		
		
		// Write the entire command list to a file
	//	for(int i = 0; i < commandSequence.size(); i++){
	//		try {
	//			outputStream.write(commandSequence.getCommand(i).getAsByteArray());
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//			return false;
	//		}
	//	}
		
		
		// Close the output stream
	//	try {
	//		outputStream.close();
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//		return false;
	//	}
	//	
	//	return true;
		try {
			for (Datapacket d : commandList) {
				out.write(d.getMovementCommandName());
			}
			out.flush();
			return true;
		} catch (IOException e) {
			e1.printStackTrace();
			return false;
		}
	}
	
	
	/*
	 * Load a saved command sequence from a file on disk
	 */
	public boolean loadSequenceFromFile(String filepath){
				Scanner what;
		try {
			what = new Scanner(file);
			int size = 0;
			while(what.hasNextLine(){
				size++;
				what.nextLine();
			}
			String[] output = new String[size];
			what = new Scanner(file);
			while (what.hasNextLine()) {
				output[i] = what.nextLine();
			}
			return true;
		} catch (FileNotFoundException e) {
			String[] thing = {""}; // this shouldn't happen
			return false;
		}
	}
}
