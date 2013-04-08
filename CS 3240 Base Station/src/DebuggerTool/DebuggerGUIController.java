package DebuggerTool;
public class DebuggerGUIController {

	private DebuggerGUI myGUI;
	private RobotCommunicator communicator;

	private static final int OPCODE_REGION = 0;
	private static final int PACKET_DATA_REGION_SIZE = 13;

	public DebuggerGUIController(DebuggerGUI gui) {
		myGUI = gui;
		communicator = new RobotCommunicator();
		
	}

	
	public void step(){
		
		// Create array and initialize all data to zero
		byte[] byteArray = new byte[PACKET_DATA_REGION_SIZE];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}
						
		byteArray[OPCODE_REGION] = DataPacket.DEBUG_STEP;
		
		DataPacket packet = new DataPacket(DataPacket.OP_DEBUGGER_COMMAND, byteArray);
		communicator.sendDataPacketToRobot(packet);
		
		
	}
}
