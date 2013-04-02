import java.awt.event.KeyEvent;

public class BaseStationGUIController {

	CommandSequenceManager myCommandSequenceManager = new CommandSequenceManager();
	TelemetryDataManager myTelemetryDataManager = new TelemetryDataManager();
	RobotCommunicator myCommunicator = new RobotCommunicator();
	BaseStationGUI myGUI;

	// 0 - up
	// 1 - down
	// 2 -left
	// 3 - right

	boolean[] movementKeysUp = new boolean[4];

	public BaseStationGUIController(BaseStationGUI guiInstance) {
		myGUI = guiInstance;

		for (int i = 0; i < movementKeysUp.length; i++) {
			movementKeysUp[i] = true;
		}

	}

	public void terminateRobot() {
		DataPacket currCommand = myCommunicator
				.sendMovementCommand(DataPacket.ERROR_DISCONNECTED);

		LogAndDisplay(currCommand);
	}

	public void stopRobot() {
		DataPacket currCommand = myCommunicator
				.sendMovementCommand(DataPacket.MOTOR_STOP);

		LogAndDisplay(currCommand);

	}

	public boolean KeyboardMovementHandler(int keyCode, boolean keyReleased) {

		DataPacket currCommand = null;

		// 1. Check what key was pressed (up, down, left, right)
		switch (keyCode) {
		case KeyEvent.VK_UP:
			// handle up
			if (keyReleased) {
				if (!movementKeysUp[0]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_FORWARD);
					movementKeysUp[0] = true;
				}
			} else {
				if (movementKeysUp[0]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_FORWARD);
					movementKeysUp[0] = false;
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			// handle down
			if (keyReleased) {
				if (!movementKeysUp[1]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_BACKWARD);
					movementKeysUp[1] = true;
				}
			} else {
				if (movementKeysUp[1]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_BACKWARD);
					movementKeysUp[1] = false;
				}
			}
			break;
		case KeyEvent.VK_LEFT:
			// handle left
			if (keyReleased) {
				if (!movementKeysUp[2]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_LEFT);
					movementKeysUp[2] = true;
				}
			} else {
				if (movementKeysUp[2]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_LEFT);
					movementKeysUp[2] = false;
				}
			}
			break;
		case KeyEvent.VK_RIGHT:
			// handle right
			if (keyReleased) {
				if (!movementKeysUp[3]) {
					// Movement key has been lifted
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_STOP_RIGHT);
					movementKeysUp[3] = true;
				}
			} else {
				if (movementKeysUp[3]) {
					// Movement key has been pressed
					currCommand = myCommunicator
							.sendMovementCommand(DataPacket.MOTOR_RIGHT);
					movementKeysUp[3] = false;
				}
			}
			break;
		case (46):
			currCommand = myCommunicator
					.sendMovementCommand(DataPacket.MOTOR_DECREASE_SPEED);
			break;
		case (47):
			currCommand = myCommunicator
					.sendMovementCommand(DataPacket.MOTOR_INCREASE_SPEED);
			break;
		default:
			// Don't log anything?
			break;
		}

		// 2. Log the current command in the command sequence log
		LogAndDisplay(currCommand);

		return true;
	}
	
	private boolean LogAndDisplay(DataPacket currCommand){
		
		if (currCommand != null) {
			if (myCommandSequenceManager.log(currCommand)) {
				if (!((currCommand.getMovementCommandName()).equals(""))) {
					myGUI.displayCommand(currCommand.getMovementCommandName());
				}
			}
		}
		
		return true;
		
	}

}
