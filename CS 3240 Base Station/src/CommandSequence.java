import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/*
 * Basically just a list of commands 
 * 
 * This will be the object that allows the user to record/upload command lists
 * 
 * 
 */ 

public class CommandSequence {
	
	private ArrayList<DataPacket> commandList = new ArrayList<DataPacket>();
	
	public CommandSequence(){
		
	}
	
	public boolean addCommandToSequence(DataPacket command){
		return commandList.add(command);
	}
	
	public DataPacket getCommand(int index){
		return commandList.get(index);
	}
	
	public int size(){
		return commandList.size();
	}
	
	

}
