package BaseStation;
import java.awt.event.KeyEvent;

import DebuggerTool.*;

public class BaseStationGUIController {

	CommandSequenceManager myCommandSequenceManager;
	RobotCommunicator myCommunicator;
	BaseStationGUI myGUI;

	private static final int UP_KEY = 0;
	private static final int DOWN_KEY = 1;
	private static final int LEFT_KEY = 2;
	private static final int RIGHT_KEY = 3;
	
	private static final int DOT_KEY = 46;
	private static final int SLASH_KEY = 47;
	
	boolean[] movementKeysUp = new boolean[4];

	public BaseStationGUIController(BaseStationGUI guiInstance) {
		myGUI = guiInstance;

		for (int i = 0; i < movementKeysUp.length; i++) {
			movementKeysUp[i] = true;
		}

		myCommunicator = new RobotCommunicator(this);
		myCommandSequenceManager = new CommandSequenceManager();
		
	}

	public void terminateRobot() {
		DataPacket currCommand = myCommunicator
				.sendErrorCommand(DataPacket.ERROR_DISCONNECTED);

		LogAndDisplay(currCommand);
	}

	public void stopRobot() {
		DataPacket currCommand = myCommunicator
				.sendMovementCommand(DataPacket.MOTOR_STOP);

		LogAndDisplay(currCommand);

	}

	public boolean KeyboardMovementHandler(int keyCode, boolean keyReleased) {

		DataPacket currCommand = null;

		// Check what key was pressed 
		switch (keyCode) {
		case KeyEvent.VK_UP:
			// handle up
			if (keyReleased) {
				if (!movementKeysUp[UP_KEY]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_FORWARD);
					movementKeysUp[UP_KEY] = true;
					// dim up arrow
					this.myGUI.dimArrow(UP_KEY);
				}
			} else {
				if (movementKeysUp[UP_KEY]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_FORWARD);
					movementKeysUp[UP_KEY] = false;
					// light up arrow
					this.myGUI.lightArrow(UP_KEY);
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			// handle down
			if (keyReleased) {
				if (!movementKeysUp[DOWN_KEY]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_BACKWARD);
					movementKeysUp[DOWN_KEY] = true;
					// dim down arrow
					this.myGUI.dimArrow(DOWN_KEY);
				}
			} else {
				if (movementKeysUp[DOWN_KEY]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_BACKWARD);
					movementKeysUp[DOWN_KEY] = false;
					// light down arrow
					this.myGUI.lightArrow(DOWN_KEY);
				}
			}
			break;
		case KeyEvent.VK_LEFT:
			// handle left
			if (keyReleased) {
				if (!movementKeysUp[LEFT_KEY]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_LEFT);
					movementKeysUp[LEFT_KEY] = true;
					// dim left arrow
					this.myGUI.dimArrow(LEFT_KEY);
				}
			} else {
				if (movementKeysUp[LEFT_KEY]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_LEFT);
					movementKeysUp[LEFT_KEY] = false;
					// light left arrow
					this.myGUI.lightArrow(LEFT_KEY);
				}
			}
			break;
		case KeyEvent.VK_RIGHT:
			// handle right
			if (keyReleased) {
				if (!movementKeysUp[RIGHT_KEY]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_RIGHT);
					movementKeysUp[RIGHT_KEY] = true;
					// dim right arrow
					this.myGUI.dimArrow(RIGHT_KEY);
				}
			} else {
				if (movementKeysUp[RIGHT_KEY]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_RIGHT);
					movementKeysUp[RIGHT_KEY] = false;
					// light right arrow
					this.myGUI.lightArrow(RIGHT_KEY);
				}
			}
			break;
		case DOT_KEY:
			currCommand = myCommunicator
					.sendMovementCommand(DataPacket.MOTOR_DECREASE_SPEED);
			break;
		case SLASH_KEY:
			currCommand = myCommunicator
					.sendMovementCommand(DataPacket.MOTOR_INCREASE_SPEED);
			break;
		default:
			// Don't log anything?
			break;
		}


		LogAndDisplay(currCommand);

		return true;
	}
	
	public boolean LogAndDisplay(DataPacket currCommand){
		
		if (currCommand != null) {
			if (myCommandSequenceManager.log(currCommand)) {
				if (!((currCommand.getMovementCommandName()).equals(""))) {
					myGUI.displayCommand(currCommand.getMovementCommandName());
				}
			}
		}
		
		return true;
		
	}
	
	public boolean DisplayTelemetryData(TelemetryData telemData){
		
		if(telemData.getTouchSensorData()){
			myGUI.setTouchDataText("Pressed");
		}else{
			myGUI.setTouchDataText("Not Pressed");
		}
		
		myGUI.setLightDataText("" + telemData.getLightSensorData());
		myGUI.setSoundDataText("" + telemData.getSoundSensorData());
		myGUI.setUltrasonicDataText("" + telemData.getUltrasonicSensorData());
		
		return true;
	}
	
	public void launchDebugger(){
		myCommunicator.setDebugging(true);
		DebuggerGUI.main(null, myCommunicator);
		System.out.println("DEBUGGER LAUNCHED");
	}
	
	public void setBlueToothStatus(boolean on){
		if (on){
			myGUI.setBlueToothLabel("On");
		}else{
			myGUI.setBlueToothLabel("Off");
		}
		
	}
	
	public void executeSequence() {
		if(myCommandSequenceManager.getCommandSequence().size()>0) {
			int i = 0;
			long offset = myCommandSequenceManager.getCommandSequence().getTime(0);
			long start = System.currentTimeMillis();
			while (i<myCommandSequenceManager.getCommandSequence().size()) {
				if(System.currentTimeMillis()-start > myCommandSequenceManager.getCommandSequence().getTime(i) - offset) {
					myCommunicator.sendDataPacketToRobot(myCommandSequenceManager.getCommandSequence().getCommand(i));
					i++;
				}
			}
		}
	}

}
