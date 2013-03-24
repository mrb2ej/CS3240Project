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
		
		// 1. Check what key was pressed (up, down, left, right)
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up
	        	myCommunicator.sendForwardCommand();
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 
	        	myCommunicator.sendBackwardCommand();
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	myCommunicator.sendLeftCommand();
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	myCommunicator.sendRightCommand();
	            break;
	     }
		
		
		// 4. Store command in CommandSequence through CommandSequenceManager
		
		
		
		
		return true;
	}

}
