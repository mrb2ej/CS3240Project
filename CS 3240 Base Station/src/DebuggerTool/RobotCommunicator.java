package DebuggerTool;
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
	
	private static final int OPCODE_REGION = 0;
	private static final int PACKET_DATA_REGION_SIZE = 13;

	public RobotCommunicator() {

		conn = new NXTConnector();
		boolean connected = conn.connectTo();
		if (!connected) {
			//Can't connect
			System.out.println("ERROR: CANNOT CONNECT TO ROBOT");
			
			// TODO: Attempt to reconnect
			
			return;
		}else{
			System.out.println("CONNECTED! ATTEMPTING TO GET INPUT STREAM");
		}
	
		
		
	}

	public boolean sendDataPacketToRobot(DataPacket packet){
		return sendDataToRobot(packet.getAsByteArray());
	}
	
		
	private boolean sendDataToRobot(byte[] message){
		
		OutputStream outStream = conn.getOutputStream();
		
		if(outStream == null){
			System.out.println("ERROR: COULD NOT CREATE OUTPUT STREAM TO ROBOT");
			return false;
		}
		
		try {
			outStream.write(message);
			outStream.flush();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("ERROR: COULD NOT SEND PACKET TO ROBOT");
			return false;
		}
		
		return true;
	}
	
	
	
	
	

}
