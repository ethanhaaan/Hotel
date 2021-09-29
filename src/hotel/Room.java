package hotel;

import java.util.List;

public class Room {

	String name;
	Room north;
	Room east;
	Room south;
	Room west;
	
	public Room(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}	
	public void setNorth(Room r) {
		north = r;
	}
	public void setEast(Room r) {
		east = r;
	}
	public void setSouth(Room r) {
		south = r;
	}
	public void setWest(Room r) {
		west = r;
	}
	public Room getNorth() {
		return north;
	}
	public Room getEast() {
		return east;
	}
	public Room getSouth() {
		return south;
	}
	public Room getWest() {
		return west;
	}
	public boolean hasNorth() {
		if(north!=null)
			return true;
		else
			return false;
	}
	public boolean hasEast() {
		if(east!=null)
			return true;
		else
			return false;
	}
	public boolean hasSouth() {
		if(south!=null)
			return true;
		else
			return false;
	}
	public boolean hasWest() {
		if(west!=null)
			return true;
		else
			return false;
	}
	
	public void printRoom() {
		String N = "-";
		String E = "|";
		String S = "-";
		String W = "|";
		if(hasNorth())
			N = "N";
		if(hasEast())
			E = "E";
		if(hasSouth())
			S = "S";
		if(hasWest())
			W = "W";
		System.out.printf("%S%n", name);
		System.out.printf(" ---%s--- %n|       |%n|       |%n%s       %s%n|       |%n|       |%n ---%s---%n", N, W, E, S);
		
	}
	
	public static Room getRoom(String name, List<Room> rooms) {
		for(Room i : rooms) {
			if(i.getName().equals(name))
				return i;
		}
		return null;
	}
	
}
