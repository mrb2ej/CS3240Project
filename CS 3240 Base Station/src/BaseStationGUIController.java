
public class BaseStationGUIController {
	
	CommandSequenceManager myCommandSequenceManager = new CommandSequenceManager();
	TelemetryDataManager myTelemetryDataManager = new TelemetryDataManager();
	RobotCommunicator myCommunicator = new RobotCommunicator();
	BaseStationGUI myGUI = new BaseStationGUI();
	
	
	public BaseStationGUIController(BaseStationGUI guiInstance){
		myGUI = guiInstance;
		
	}
	
	
	
	public boolean KeyboardMovementHandler(){
		
		// 1. Check what key was pressed (up, down, left, right)
		// 2. Create a data packet with the movement command 
		// 3. Using RobotCommunicator, send the data to the robot
		// 4. Store command in CommandSequence through CommandSequenceManager
		
		
		
		
		return true;
	}

}
