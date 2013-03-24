/*
 * This will be the module that allows the base station to communicate with the robot 
 * 
 * This will be the module that manages all of the DataPacket creation and transmission 
 * 
 * 
 */

public class RobotCommunicator {

	// DataPacket currentPacket = new DataPacket();

	public RobotCommunicator() {

	}

	public DataPacket sendForwardCommand() {
		// Create array and initialize all data to zero
		byte[] byteArray = new byte[5];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		// Set movement forward for motor 0 and motor 1
		byteArray[0] = DataPacket.MOTOR_FORWARD;

		DataPacket currentPacket = new DataPacket(DataPacket.OP_MOTOR_COMMAND,
				byteArray);

		// Send that packet
		// No idea how this is going to happen yet

		return currentPacket;
	}

	public DataPacket sendBackwardCommand() {
		// Create array and initialize all data to zero
		byte[] byteArray = new byte[5];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		// Set movement forward for motor 0 and motor 1
		byteArray[0] = DataPacket.MOTOR_BACKWARD;

		DataPacket currentPacket = new DataPacket(DataPacket.OP_MOTOR_COMMAND,
				byteArray);

		// Send that packet
		// No idea how this is going to happen yet

		return currentPacket;
	}

	public DataPacket sendLeftCommand() {
		// Create array and initialize all data to zero
		byte[] byteArray = new byte[5];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		// Set movement forward for motor 0 and motor 1
		byteArray[0] = DataPacket.MOTOR_LEFT;

		DataPacket currentPacket = new DataPacket(DataPacket.OP_MOTOR_COMMAND,
				byteArray);

		// Send that packet
		// No idea how this is going to happen yet

		return currentPacket;
	}

	public DataPacket sendRightCommand() {
		// Create array and initialize all data to zero
		byte[] byteArray = new byte[5];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = 0;
		}

		// Set movement forward for motor 0 and motor 1
		byteArray[0] = DataPacket.MOTOR_RIGHT;

		DataPacket currentPacket = new DataPacket(DataPacket.OP_MOTOR_COMMAND,
				byteArray);

		// Send that packet
		// No idea how this is going to happen yet

		return currentPacket;
	}

}
