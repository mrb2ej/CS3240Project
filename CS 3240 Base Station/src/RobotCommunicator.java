import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTConnector;

/*
 * This will be the module that allows the base station to communicate with the robot 
 * 
 * This will be the module that manages all of the DataPacket creation and transmission 
 * 
 * 
 */

public class RobotCommunicator {

	private NXTConnector conn;
	private InputStream inStream;
	private TelemetryDataManager telemDataManager;

	public RobotCommunicator() {

		conn = new NXTConnector();
		boolean connected = conn.connectTo();
		if (!connected) {
			//Can't connect
			System.out.println("Can't connect");
			
			// TODO: Attempt to reconnect
			
			return;
		}
	
		
		// Setup the telemetry data manager that will handle all input from the robot
		inStream = conn.getInputStream();
		telemDataManager = new TelemetryDataManager(inStream);
		
	}

	public DataPacket sendMovementCommand(byte opcode) {

		System.out.println("Sending movement command with opcode: " + opcode);

		// Create array and initialize all data to zero
		byte[] byteArray = new byte[5];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}


		byteArray[0] = opcode;
		DataPacket currentPacket = new DataPacket(DataPacket.OP_MOTOR_COMMAND, byteArray);

		sendDataToRobot(currentPacket.getAsByteArray());

		return currentPacket;
	}
	
	public DataPacket sendErrorCommand(byte opcode){

		System.out.println("Sending error command with opcode: " + opcode);

		// Create array and initialize all data to zero
		byte[] byteArray = new byte[5];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		byteArray[0] = opcode;
		DataPacket currentPacket = new DataPacket(DataPacket.OP_ERROR, byteArray);


		sendDataToRobot(currentPacket.getAsByteArray());

		return currentPacket;
		
	}
	
		
	private boolean sendDataToRobot(byte[] message){
		
		OutputStream outStream = conn.getOutputStream();
		
		try {
			outStream.write(message);
			outStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	

}
