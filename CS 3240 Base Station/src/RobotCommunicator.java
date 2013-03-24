/*
 * This will be the module that allows the base station to communicate with the robot 
 * 
 * This will be the module that manages all of the DataPacket creation and transmission 
 * 
 * 
 */

public class RobotCommunicator {

	//DataPacket currentPacket = new DataPacket();
	
	public RobotCommunicator(){
		
	}
	
	
	public boolean sendForwardCommand(){
		DataPacket currentPacket = new DataPacket();
		currentPacket.setOpcode(2);
		
		// Create array and intialize all data to zero
		byte[] byteArray = new byte[24];
		for(int i = 0; i < byteArray.length; i++){
			byteArray[0] = 0;
		}
		
		// Set movement forward for motor 0 and motor 1
		byteArray[0] = 0;
		byteArray[1] = 3;
		byteArray[2] = 0;
		byteArray[3] = 1;
		byteArray[4] = 3;
		byteArray[5] = 0;
		currentPacket.setData(byteArray);
		currentPacket.setEnd(0xFF);
		currentPacket.calculateChecksum();
		
		//Send that packet
		// No idea how this is going to happen yet
		
		
		return true;
	}
	
	public boolean sendBackwardCommand(){
		
		
		return true;
	}

	public boolean sendLeftCommand(){
		
		
		return true;
	}
	
	public boolean sendRightCommand(){
		
		
		return true;
	}
	
}
