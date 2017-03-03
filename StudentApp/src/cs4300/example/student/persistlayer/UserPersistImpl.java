/**
 * 
 */
package cs4300.example.student.persistlayer;

import cs4300.example.student.objectlayer.User;

/**
 * @author Mehdi
 *
 */
public class UserPersistImpl {

	public int persistUser(User u) {
		String sql = "INSERT INTO users (firstname,lastname,email,username,password) VALUES"
				+ "('" + u.getFirstname() + "','" + u.getLastname();
		return DatabaseAccess.insert(sql);
	}

}
