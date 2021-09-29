package hotel;

import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class HotelLoader {

	String[] rooms;
	List<String[]> roomdata;
	
	public void load(String path) {
		List<String[]> roomdata = new ArrayList<String[]>();
		try {
			Scanner scanobj = new Scanner(new File(path));
			this.rooms = scanobj.nextLine().split(" ");
			while(scanobj.hasNextLine()) {
				roomdata.add(scanobj.nextLine().split(" > "));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Unsuccessful");
		}
		this.roomdata = roomdata;
	}
	public String[] getRooms() {
		return rooms;
	}
	public List<String[]> getRoomData() {
		return roomdata;
	}
	
}
