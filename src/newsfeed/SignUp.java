package newsfeed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SignUp {
	public Set<User> getRegisteredUsers() {
		return registeredUsers;
	}
	public void setRegisteredUsers(Set<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}
	Set<User> registeredUsers= new HashSet<User>();
	public void addUser(User user)
	{
		if(user!=null)
		{
			registeredUsers.add(user);
		}
	}

}
