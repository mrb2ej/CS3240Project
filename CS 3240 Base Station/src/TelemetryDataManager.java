import java.io.IOException;
import java.io.InputStream;

/*
 * This module will be in charge of creating and parsing TelemetryData objects
 * 
 *  When the RobotCommunicator object receives a DataPacket object from the robot and parses that information,
 *  it will use a TelemetryDataManager object to create a TelemetryData object that will then be displayed by the 
 *  BaseStationGUIController to the BaseStationGUI object
 * 
 * If we ever need to serialize TelemetryData objects, this is the module that will manage the saving/loading
 * of the (.txt?) file
 * 
 */

public class TelemetryDataManager implements Runnable {

	InputStream inStream;
		
	public TelemetryDataManager(InputStream inStream){
		this.inStream = inStream;
		
	}

	@Override
	public void run() {
		int z = 0;
		while (z == 0){
			receiveCommand();
		}
	}
	
	public DataPacket receiveCommand(){
				
		DataPacket packet = new DataPacket(receiveDataFromRobot());
		
		//Ensure the checksum is correct
		if(packet.calcChkSum() != packet.checkSum){
			//The checksum doesn't match, send an error to the robot
		}
		
		System.out.println("Received a proper command from the robot");
		
		//Parse out the telemetry data
		
		//Display the telemetry data to the user
		
		return packet;
	}
	
	private byte[] receiveDataFromRobot(){
		
		byte[] message = new byte[7];
		
		try {
			inStream.read(message);   //Is this a blocking call?
		} catch (IOException e) {
			e.printStackTrace();
			return message;
		}
		return message;
		
	}
	
}
