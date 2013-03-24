import java.awt.event.KeyEvent;


public class BaseStationGUIController {
	
	CommandSequenceManager myCommandSequenceManager = new CommandSequenceManager();
	TelemetryDataManager myTelemetryDataManager = new TelemetryDataManager();
	RobotCommunicator myCommunicator = new RobotCommunicator();
	BaseStationGUI myGUI;
	
	
	public BaseStationGUIController(BaseStationGUI guiInstance){
		myGUI = guiInstance;
		
	}
	
	
	
	public boolean KeyboardMovementHandler(int keyCode){
		
		DataPacket currCommand = null;
		
		// 1. Check what key was pressed (up, down, left, right)
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up
	        	currCommand = myCommunicator.sendForwardCommand();
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 
	        	currCommand = myCommunicator.sendBackwardCommand();
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	currCommand = myCommunicator.sendLeftCommand();
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	currCommand = myCommunicator.sendRightCommand();
	            break;
	        default : 
	        	//Don't log anything?
	     }		
		
	    //2. Log the current command in the command sequence log
    	myCommandSequenceManager.log(currCommand);

		
		return true;
	}

}
