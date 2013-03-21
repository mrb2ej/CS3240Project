import java.util.Scanner;

public class TestToolDriver {

	public static void main(String[] args) {
		TestTool myTestTool = new TestTool();

		Scanner scanner = new Scanner(System.in);
		String input = "";
		DataPacket properPacket = new DataPacket();
		properPacket.setOpcode(2);
		properPacket.setData(0, 0, 2, 0, 0, 0);
		properPacket.setChecksum(properPacket.getSum());
		
		DataPacket corruptPacket = new DataPacket();
		corruptPacket.setOpcode(2);
		corruptPacket.setData(0, 0, 2, 0, 0, 0);
		corruptPacket.setChecksum(corruptPacket.getSum() + 1);
		
		

		while (!input.equals("4")) {
			System.out.println("Commands:\n(1) Send formatted command\n(2) Send corrupted command\n(3) Generate telemetry data\n(4) Quit");
			System.out.print("Enter a command: ");
			input = scanner.nextLine();
			System.out.println();
			
			switch(Integer.parseInt(input)){
			case 1:
				myTestTool.parseCommand(properPacket);
				break;
			case 2:
				myTestTool.parseCommand(corruptPacket);
				break;
			case 3:
				myTestTool.transmitPacket(myTestTool.generateTelemetryData());
				break;	
			case 4:
				System.out.println("Terminating");
				break;
			default:
				System.out.println("Incorrect command, please try again");
				break;
			}
			
		}

	}

}
