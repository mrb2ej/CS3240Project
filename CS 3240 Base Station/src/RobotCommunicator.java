import java.io.IOException;
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

	public RobotCommunicator() {

		conn = new NXTConnector();
		boolean connected = conn.connectTo(NXTComm.RAW);
		if (!connected) {
			//Can't connect
			System.out.println("Can't connect");
			return;
		}
		
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
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		*/
		return true;
	}

}
