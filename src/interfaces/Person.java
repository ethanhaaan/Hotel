package interfaces;

import java.util.List;
import java.util.ArrayList;

public class Person implements Interactable {

	private String name;
	private List<String> contact;
	private List<String> responses;

	public Person(String name, List<String> contact, List<String> responses) {
		this.name = name;
		this.contact = contact;
		this.responses = responses;
	}
	
	public void talkTo(Interactable thing) {
		System.out.println("Hi, my name is " + name);
		for(int i = 0; i < contact.size() && i < responses.size(); i++) {
			System.out.println(contact.get(i));
			System.out.println(responses.get(i));
		}
	}
	
	public List<String> responseScript() {
		return responses;
	}
	
	public List<String> contactScript() {
		return contact;
	}
	
	public String getName() {
		return name;
	}
	
}
