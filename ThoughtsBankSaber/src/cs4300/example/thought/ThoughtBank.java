/**
 * 
 */
package cs4300.example.thought;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mehdi
 *
 */
public class ThoughtBank {
	
	private Map<String, List<Thought>> tbank;
	private int size;
	
	public ThoughtBank() {
		tbank = new HashMap<String,List<Thought>>();
		size  = 0;
	}
	
	public void add(String user, Thought thought) {
		List<Thought> uthoughts = tbank.get(user);
		if (uthoughts ==  null) {
			uthoughts = new ArrayList<Thought>();
			uthoughts.add(thought);
			tbank.put(user, uthoughts);
		}else {
			uthoughts.add(thought);
			tbank.put(user, uthoughts);
		}
		size++;
	} // end of add
	
	public List<Thought> getThoughts(String user) {
		return tbank.get(user);
	} // end of getThoughts

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		String result= "";
		for (Map.Entry<String, List<Thought>> entry : tbank.entrySet()) {
			String user = entry.getKey();
			List<Thought> tlist = entry.getValue();
			result += user + "\n";
			for (Thought t : tlist) {
				result += t + "\n";
			}
		} // end of for
		return result;
	}

}
