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

	public RobotCommunicator() {

		conn = new NXTConnector();
		boolean connected = conn.connectTo();
		if (!connected) {
			//Can't connect
			System.out.println("Can't connect");
			return;
		}
		
		inStream = conn.getInputStream();
		
	}

	public DataPacket sendMovementCommand(byte opcode) {

		System.out.println("Sending command with opcode: " + opcode);

		// Create array and initialize all data to zero
		byte[] byteArray = new byte[5];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		// Set movement forward for motor 0 and motor 1
		byteArray[0] = opcode;

		DataPacket currentPacket = new DataPacket(DataPacket.OP_MOTOR_COMMAND, byteArray);

		// Send that packet
		sendDataToRobot(currentPacket.getAsByteArray());

		return currentPacket;
	}
	
	private boolean sendDataToRobot(byte[] message){
		/*
		OutputStream outStream = conn.getOutputStream();
		
		try {
			outStream.write(message);
			outStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		*/
		return true;
	}
	
	private byte[] receiveDataFromRobot(){
	
		byte[] message = new byte[7];
		
		try {
			inStream.read(message);
		} catch (IOException e) {
			e.printStackTrace();
			return message;
		}
		return message;
		
	}
	
	
	
	

}
