/**
 * 
 */
package cs4300.example.thought;

/**
 * @author Mehdi
 *
 */
public class Thought {
	
	private String thought;
	
	public Thought() {
		
	}
	
	public Thought(String thought) {
		this.setThought(thought);
	}

	/**
	 * @return the thought
	 */
	public String getThought() {
		return thought;
	}

	/**
	 * @param thought the thought to set
	 */
	public void setThought(String thought) {
		this.thought = thought;
	}
	
	@Override
	public String toString() {
		return thought + "\n";
	}
	
	
}
