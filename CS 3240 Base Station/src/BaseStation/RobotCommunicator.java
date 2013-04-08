package BaseStation;
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
	
	private static final int OPCODE_REGION = 0;
	private static final int PACKET_DATA_REGION_SIZE = 13;

	public RobotCommunicator(BaseStationGUIController guiController) {

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
	
		
		// Setup the telemetry data manager that will handle all input from the robot
		inStream = conn.getInputStream();
		
		if(inStream != null){
			System.out.println("RECEIVED INPUT STREAM FROM ROBOT");
			telemDataManager = new TelemetryDataManager(inStream, guiController);
		}else{
			System.out.println("ERROR: CANNOT GET INPUT STREAM FROM ROBOT");
		}
		
		
	}

	public DataPacket sendMovementCommand(byte opcode) {

		System.out.println("Sending movement command with opcode: " + opcode);

		// Create array and initialize all data to zero
		byte[] byteArray = new byte[PACKET_DATA_REGION_SIZE];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		
		byteArray[OPCODE_REGION] = opcode;
		DataPacket currentPacket = new DataPacket(DataPacket.OP_MOTOR_COMMAND, byteArray);

		sendDataToRobot(currentPacket.getAsByteArray());

		return currentPacket;
	}
	
	public DataPacket sendErrorCommand(byte opcode){

		System.out.println("Sending error command with opcode: " + opcode);

		// Create array and initialize all data to zero
		byte[] byteArray = new byte[PACKET_DATA_REGION_SIZE];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		byteArray[OPCODE_REGION] = opcode;
		DataPacket currentPacket = new DataPacket(DataPacket.OP_ERROR, byteArray);


		sendDataToRobot(currentPacket.getAsByteArray());

		return currentPacket;
		
	}
	
	public NXTConnector getConnection(){
		return conn;
	}
	
	public boolean sendDataPacketToRobot(DataPacket packet){
		return sendDataToRobot(packet.getAsByteArray());
	}
	
	public void step(){
		
		// Create array and initialize all data to zero
		byte[] byteArray = new byte[PACKET_DATA_REGION_SIZE];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}
						
		byteArray[OPCODE_REGION] = DataPacket.DEBUG_STEP;
		
		DataPacket packet = new DataPacket(DataPacket.OP_DEBUGGER_COMMAND, byteArray);
		sendDataPacketToRobot(packet);
		
		
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
