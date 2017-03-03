/**
 * 
 */
package cs4300.example.student.logiclayer;

import cs4300.example.student.objectlayer.User;
import cs4300.example.student.persistlayer.UserPersistImpl;

/**
 * @author Mehdi
 *
 */
public class UserLogicImpl {
	
	UserPersistImpl userPersist;
	
	public UserLogicImpl() {
		userPersist = new UserPersistImpl();
	}
	
	public int insertUser(String fname, String lname, String email, String username, String password) {
		User u = new User(fname,lname,email,username,password);
		return userPersist.persistUser(u);
	}

}
