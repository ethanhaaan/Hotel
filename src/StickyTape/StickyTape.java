package StickyTape;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class StickyTape {
	
	public static void main(String[] args) {
		for(String i : args) {
			if(!(new File(i).exists()))
				System.out.println("Unable to load file " + i);
		}
		List<List<String>> array = new ArrayList<List<String>>();
		try {
			for(String i : args) {
				Scanner scanobj = new Scanner(new File(i));
				List<String> arrayline = new ArrayList<String>();
				while(scanobj.hasNextLine()) {
					arrayline.add(scanobj.nextLine());
				}
				array.add(arrayline);
			}
		}
		catch(FileNotFoundException e) {
		}
		//calculating max array size
		int max = 0;
		for(List<String> i : array) {
			if(i.size() > max)
				max = i.size();
		}
		//Iterates lines
		for(int i = 0; i < max; i++) {
			//Iterates files
			for(int j = 0; j < array.size(); j++) {
				if(i >= array.get(j).size()) {
					System.out.print("\t");
					continue;
				}
				else {
					System.out.print(array.get(j).get(i));
					if(j != array.size()-1)
						System.out.print("\t");
				}
			}
			System.out.println("");
		}
	}
}