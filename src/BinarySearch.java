import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class BinarySearch {
	
	public static int[] readFile(String filename) {
		List<Integer> temp = new ArrayList<Integer>();
		try {
			Scanner scanobj = new Scanner(new File(filename));
			while(scanobj.hasNextInt())
				temp.add(scanobj.nextInt());
		}
		catch (FileNotFoundException e) {
		}
		int[] returnint = new int[temp.size()];
		for(int i = 0; i < temp.size(); i++)
			returnint[i] = temp.get(i).intValue();
		return returnint;
	}
	
	public static int binarySearch(int low, int high, int search, int[] array) {
		int mid = (int)(low+high)/2;
		if(low > high) {
			return -1;
		}
		else if(array[mid] == search) {
			return array[mid];
		}
		else if(array[mid] > search) {
			return binarySearch(low, mid-1, search, array);
		}
		else {
			return binarySearch(mid+1, high, search, array);
		}
		
	}
	
	public static void main(String[] args) {
		if(binarySearch(0, readFile(args[1]).length-1, Integer.parseInt(args[0]), readFile(args[1])) != -1)
			System.out.println("Found");
		else
			System.out.println("Not Found");
	}
}