package DebuggerTool;

import BaseStation.RobotCommunicator;

public class DebuggerGUIController {

	private DebuggerGUI myGUI;
	private RobotCommunicator communicator;

	private static final int OPCODE_REGION = 0;
	private static final int PACKET_DATA_REGION_SIZE = 13;

	public DebuggerGUIController(DebuggerGUI gui, RobotCommunicator communicator) {
		myGUI = gui;
		this.communicator = communicator;
		
	}

	public void step(){
		communicator.stepDebugger();
	}
	
	public void stop(){
		communicator.stopDebugger();
	}
	
	
	
}
