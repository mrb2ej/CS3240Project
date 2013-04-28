package BaseStation;
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
	private ArrayList<Long> timeList = new ArrayList<Long>();
	
	public CommandSequence(){
		
	}
	
	public boolean addCommandToSequence(DataPacket command){
		timeList.add(System.currentTimeMillis());
		return commandList.add(command);
	}
	
	public void clearTime() {
		timeList.clear();
	}
	
	public Boolean addTime(long time) {
		return timeList.add(time);
	}
	
	public void endCommandTimer() {	//this is important to record the correct time, call after the last recorded command is finished
		if(size()>0) {
			long temp = timeList.get(size()-1);
			temp = System.currentTimeMillis() - temp;
			timeList.remove(size()-1);
			timeList.add(temp);
		}
	}
	
	public DataPacket getCommand(int index){
		return commandList.get(index);
	}
	
	public long getTime(int index){
		return timeList.get(index);
	}
	
	public int size(){
		return commandList.size();
	}
	
	public void clear() {
		commandList.clear();
		timeList.clear();
	}
}
