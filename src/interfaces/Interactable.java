package interfaces;

import java.util.List;
import java.util.ArrayList;

public interface Interactable {

	public void talkTo(Interactable thing);
	
	public List<String> responseScript();
	
	public List<String> contactScript();
	
}
