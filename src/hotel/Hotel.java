package hotel;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
	
	public static void main(String[] args) {
		List<Room> rooms = new ArrayList<Room>();
		HotelLoader loader = new HotelLoader();
		loader.load(args[0]);
		
		for(String[] i : loader.getRoomData()) {
			String tempRoomName = i[0];
			String direction = i[1];
			String reference = i[2];
			
			if(Room.getRoom(tempRoomName, rooms) == null) {
				rooms.add(new Room(tempRoomName));
			}
			if(Room.getRoom(reference, rooms) == null) {
				rooms.add(new Room(reference));
			}
			if(direction.equalsIgnoreCase("North")){
				Room.getRoom(tempRoomName, rooms).setNorth(Room.getRoom(reference, rooms));
				Room.getRoom(reference, rooms).setSouth(Room.getRoom(tempRoomName, rooms));
			}
			else if(direction.equalsIgnoreCase("East")){
				Room.getRoom(tempRoomName, rooms).setEast(Room.getRoom(reference, rooms));
				Room.getRoom(reference, rooms).setWest(Room.getRoom(tempRoomName, rooms));
			}
			else if(direction.equalsIgnoreCase("South")){
				Room.getRoom(tempRoomName, rooms).setSouth(Room.getRoom(reference, rooms));
				Room.getRoom(reference, rooms).setNorth(Room.getRoom(tempRoomName, rooms));
			}
			else if(direction.equalsIgnoreCase("West")){
				Room.getRoom(tempRoomName, rooms).setWest(Room.getRoom(reference, rooms));
				Room.getRoom(reference, rooms).setEast(Room.getRoom(tempRoomName, rooms));
			}
		}
		Scanner scanobj = new Scanner(System.in);
		Room currentRoom = Room.getRoom("START", rooms);
		currentRoom.printRoom();
		while(scanobj.hasNext()) {
			String cmd = scanobj.next();
			if(cmd.equalsIgnoreCase("north")) {
				if(!currentRoom.hasNorth()) {
					System.out.println("No Path This Way");
					continue;
				}
				else {
					currentRoom = currentRoom.getNorth();
				}
			}
			else if(cmd.equalsIgnoreCase("east")) {
				if(!currentRoom.hasEast()) {
					System.out.println("No Path This Way");
					continue;
				}
				else {
					currentRoom = currentRoom.getEast();
				}
			}
			else if(cmd.equalsIgnoreCase("south")) {
				if(!currentRoom.hasSouth()) {
					System.out.println("No Path This Way");
					continue;
				}
				else {
					currentRoom = currentRoom.getSouth();

				}
			}
			else if(cmd.equalsIgnoreCase("west")) {
				if(!currentRoom.hasWest()) {
					System.out.println("No Path This Way");
					continue;
				}
				else {
					currentRoom = currentRoom.getWest();

				}
			}
			currentRoom.printRoom();
			
		}
	}
}
